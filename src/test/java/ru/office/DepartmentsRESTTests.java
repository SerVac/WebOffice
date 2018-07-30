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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.office.entity.Department;
import ru.office.service.DepartmentService;

import java.util.List;
import java.util.Map;
import java.util.Set;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@PropertySource(value = {"classpath:/application-test.properties"}, encoding = "UTF-8")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class DepartmentsRESTTests {

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
    public void setUp(){
        HttpTestUtils.generateApiMap("http://localhost:"+this.port);
    }

    @Test
    public void getDepartment() throws Exception {
        List<Department> departments = departmentService.findAll();

        String allDepartmentsURL = HttpTestUtils.apiMap.get(HttpTestUtils.WebAPI.ALL_DEPARTMENTS);
        ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(allDepartmentsURL, Map.class);
        Set entry = entity.getBody().entrySet();

        HttpResponse response = HttpTestUtils.httpApiGet(HttpTestUtils.WebAPI.ALL_DEPARTMENTS);
        HttpEntity respEntity = response.getEntity();
        String responseString = EntityUtils.toString(respEntity, "UTF-8");
    }

}