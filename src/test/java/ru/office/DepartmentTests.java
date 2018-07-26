package ru.office;

import org.junit.Before;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.office.entity.Department;
import ru.office.service.DepartmentService;

import javax.annotation.Resource;
import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc()
//@Transactional
//@ContextConfiguration(classes = {DepartmentService.class, Department.class, CrudService.class})
@SpringBootTest
@DataJpaTest
@Import({AppTestConfiguration.class, DepartmentService.class})
@PropertySource(value = {"classpath:/application-test.properties"}, encoding = "UTF-8")
//@FixMethodOrder(MethodSorters.DEFAULT)
public class DepartmentTests {


//    @Autowired
//    private MockMvc mockMvc;

//        @Autowired
//    @Resource
//    private WebApplicationContext context;

//    @Mock
    @Autowired
    private DepartmentService departmentService;

    private final String DEPARTMENT_LOCATION = Department.TABLE_NAME;
    private final String REST_DEPARTMENT_LOCATION = "/" + DEPARTMENT_LOCATION;


//    private HttpMessageConverter mappingJackson2HttpMessageConverter;


//    @Before
//    public void setUp() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
//    }


    /*
        @Before
        public void deleteAllBeforeTests() throws Exception {
            companyRepository.deleteAll();
        }
    */
    private MediaType contentType = new MediaType("application", "hal+json", Charset.forName("UTF-8"));

    @Test
    public void shouldQueryEntity() throws Exception {
//        mockMvc.perform(get("/todo/add"));

        String TITLE = "test_c1_office1_dep1";
        Department department = departmentService.get((long) 1);

      /*  mockMvc.perform(get(REST_DEPARTMENT_LOCATION+"/1"))
//                .andExpect(content().contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..@", hasSize(0)))
                .andExpect(jsonPath("$.title", is(TITLE)));*/

    }

 /*   @Test
    public void findByTitle() throws Exception {
        String TITLE = "test_c1_office1_dep1";
        mockMvc.perform(
                get(REST_DEPARTMENT_LOCATION + "/search/findByTitle?title={title}", TITLE))
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
        mockMvc.perform(post(REST_DEPARTMENT_LOCATION)
                .content(this.json(new Department()))
                .contentType(contentType))
                .andExpect(status().isNotFound());
    }*/


}