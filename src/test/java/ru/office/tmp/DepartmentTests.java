package ru.office;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.office.entity.Department;
import ru.office.service.DepartmentService;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DataJpaTest
@Import({AppTestConfiguration.class, DepartmentService.class})
@PropertySource(value = {"classpath:/application-test.properties"}, encoding = "UTF-8")
//@FixMethodOrder(MethodSorters.DEFAULT)
public class DepartmentTests {


    @Autowired
    private DepartmentService departmentService;

    private final String DEPARTMENT_LOCATION = Department.TABLE_NAME;
    private final String API_DEPARTMENTS = DEPARTMENT_LOCATION + "/";


//    private HttpMessageConverter mappingJackson2HttpMessageConverter;


    /*
        @Before
        public void deleteAllBeforeTests() throws Exception {
            companyRepository.deleteAll();
        }
    */
    private MediaType contentType = new MediaType("application", "hal+json", Charset.forName("UTF-8"));

    @Test
    public void getDepartmentByServiceAndRest() throws Exception {
        String TITLE = "test_c1_office1_dep1";
        Department department = departmentService.get((long) 1);

//        HttpResponse response = TestUtils.httpGet(API_DEPARTMENTS + 1);
//        HttpEntity entity = response.getEntity();

    }

 /*   @Test
    public void findByTitle() throws Exception {
        String TITLE = "test_c1_office1_dep1";
        mockMvc.perform(
                get(API_DEPARTMENTS + "/search/findByTitle?title={title}", TITLE))
                .andExpect(status().isOk())
                .andExpect(
                        jsonPath("$._embedded." + DEPARTMENT_LOCATION + "[0].title")
                                .value(TITLE)
                );
    }
*/


  /* @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        for (HttpMessageConverter<?> httpMessageConverter : Arrays.asList(converters)) {
            if (httpMessageConverter instanceof MappingJackson2HttpMessageConverter) {
                this.mappingJackson2HttpMessageConverter = httpMessageConverter;
            }
        }
        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }*/


 /*   @Test
    public void shouldReturnRepositoryIndex() throws Exception {
        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
                jsonPath("$._links." + DEPARTMENT_LOCATION).exists());
    }*/

   /* @Test
    public void userNotFound() throws Exception {
        mockMvc.perform(post(API_DEPARTMENTS)
                .content(this.json(new Department()))
                .contentType(contentType))
                .andExpect(status().isNotFound());
    }*/


}