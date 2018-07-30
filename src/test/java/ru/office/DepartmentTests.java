package ru.office;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;
import ru.office.config.BaseConfig;
import ru.office.entity.Department;
import ru.office.service.DepartmentService;
import ru.office.service.WorkerService;

import java.nio.charset.Charset;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@Import({BaseConfig.class})
@PropertySource(value = {"classpath:/application-test.properties"}, encoding = Application.ENCODING)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentTests {

    /*
        @Before
        public void deleteAllBeforeTests() throws Exception {
            companyRepository.deleteAll();
        }
         private HttpMessageConverter mappingJackson2HttpMessageConverter;
    */
    private MediaType contentType = new MediaType("application", "hal+json", Charset.forName("UTF-8"));

//    @Autowired
//    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private TestDataGenerator testDataGenerator;

//    @MockBean
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private WorkerService workerService;

    private final String DEPARTMENT_LOCATION = Department.TABLE_NAME;
    private final String REST_DEPARTMENT_LOCATION = "/" + DEPARTMENT_LOCATION;


    @Before
    public void setUp() {
//        List<Worker> workerList = workerService.findAll();
//        assertTrue(workerList.size() == 0);
    }



   /*
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }
    */


    @Test
    public void shouldQueryEntity() throws Exception {
        String TITLE = "test_c1_office1_dep1";
        Department department = departmentService.get((long) 1);


       /*
       mockMvc.perform(get(REST_DEPARTMENT_LOCATION+"/1"))
//                .andExpect(content().contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..@", hasSize(0)))
                .andExpect(jsonPath("$.title", is(TITLE)));
                */

    }
/*
    @Test
    public void findByTitle() throws Exception {
        String TITLE = "test_c1_office1_dep1";
        mockMvc.perform(
                get(REST_DEPARTMENT_LOCATION + "/search/findByTitle?title={title}", TITLE))
                .andExpect(status().isOk())
                .andExpect(
                        jsonPath("$._embedded." + DEPARTMENT_LOCATION + "[0].title")
                                .value(TITLE)
                );
    }*/



  /*
   @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        for (HttpMessageConverter<?> httpMessageConverter : Arrays.asList(converters)) {
            if (httpMessageConverter instanceof MappingJackson2HttpMessageConverter) {
                this.mappingJackson2HttpMessageConverter = httpMessageConverter;
            }
        }
        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }
    */


 /*
   @Test
    public void shouldReturnRepositoryIndex() throws Exception {
        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
                jsonPath("$._links." + DEPARTMENT_LOCATION).exists());
    }
    */

   /*
   @Test
    public void userNotFound() throws Exception {
        mockMvc.perform(post(REST_DEPARTMENT_LOCATION)
                .content(this.json(new Department()))
                .contentType(contentType))
                .andExpect(status().isNotFound());
    }
    */


}