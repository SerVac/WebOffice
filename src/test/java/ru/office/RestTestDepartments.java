package ru.office;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.office.entity.Department;
import ru.office.service.DepartmentService;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static ru.office.TestDataGenerator.*;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@PropertySource(value = {"classpath:/application-test.properties"}, encoding = "UTF-8")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class RestTestDepartments {

    @LocalServerPort
    private int port;

    @Value("${local.management.port}")
    private int mgt;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private TestDataGenerator testDataGenerator;

    @Autowired
    private DepartmentService departmentService;


    @Before
    public void setUp() {
        HttpTestUtils.generateApiMap("http://localhost:" + this.port);
    }

    @Test
    public void allDepartments() throws Exception {
        // service way
        List<Department> departments = departmentService.findAll();
        assertNotNull(departments);
        assertEquals(departments.size(), 16);

        // a way full of pain...  :(
        final String allDepartmentsURL = HttpTestUtils.apiMap.get(HttpTestUtils.WebAPI.ALL_DEPARTMENTS);
        ResponseEntity<Map> entity = testRestTemplate.getForEntity(allDepartmentsURL, Map.class);
        assertEquals(entity.getStatusCode(), HttpStatus.OK);
        Map respBodyMap = entity.getBody();
        Map pageMap = (Map) respBodyMap.get(PAGE);
        assertEquals(pageMap.get(TOTAL_ELEMENTS), departments.size());
        List<Map> listDepartmentsMap = (List) ((Map) respBodyMap.get(EMBEDDED)).get(DEPARTMENTS);

        departments.parallelStream().forEach(d -> {
            int dId = Math.toIntExact(d.getId());
            assertTrue(listDepartmentsMap.stream().anyMatch(dMap -> {
                int dMapId = (int) dMap.get(ID);
                return (dMapId == dId) && dMap.get(TITLE).equals(d.getTitle());
            }));
        });

        // string way
        Department department = testRestTemplate.getForObject(allDepartmentsURL + "/1", Department.class);
        String departmentStr = testRestTemplate.getForObject(allDepartmentsURL + "/1", String.class);
        ResponseEntity<Map> departmentWorkersMap = testRestTemplate.getForEntity(allDepartmentsURL + "/1/workers", Map.class);

        HttpResponse response = HttpTestUtils.httpApiGet(HttpTestUtils.WebAPI.ALL_DEPARTMENTS, "/1/workers");
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.OK.value());
        HttpEntity respEntity = response.getEntity();
        String responseString = EntityUtils.toString(respEntity, "UTF-8");
    }

}