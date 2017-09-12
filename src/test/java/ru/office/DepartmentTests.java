package ru.office;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.office.config.DatabaseManagerSwingThread;
import ru.office.dao.CompanyRepository;
import ru.office.data.entity.Department;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
//@SpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@DatabaseSetup(DepartmentTests.DATASET)
public class DepartmentTests {
    static final String DATASET = "classpath:test-data-hsqldb.sql";
  /*  private MediaType contentType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8")
    );
*/

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

//    @LocalServerPort
//    private int port;

    private final String DEPARTMENT_LOCATION = Department.TABLE_NAME;
    private final String REST_DEPARTMENT_LOCATION = "/" + DEPARTMENT_LOCATION;

    //    @Autowired
//    private DepartmentRepository departmentRepository;
    @Autowired
    private CompanyRepository companyRepository;

//    private HttpMessageConverter mappingJackson2HttpMessageConverter;


    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Before
    public void deleteAllBeforeTests() throws Exception {

//        companyRepository.deleteAll();
    }

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


    @Test
    public void shouldReturnRepositoryIndex() throws Exception {
        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
                jsonPath("$._links." + DEPARTMENT_LOCATION).exists());
    }

   /* @Test
    public void userNotFound() throws Exception {
        mockMvc.perform(post(REST_DEPARTMENT_LOCATION)
                .content(this.json(new Department()))
                .contentType(contentType))
                .andExpect(status().isNotFound());
    }*/

    @Test
    public void shouldQueryEntity() throws Exception {
        String TITLE = "c1_office1_dep1";
        mockMvc.perform(get(REST_DEPARTMENT_LOCATION).content(
                "{ \"title\": \"" + TITLE + "\"}")).andExpect(
                status().isCreated());

        /*mockMvc.perform(
                get(REST_DEPARTMENT_LOCATION + "/search/findAll?name={name}", TITLE))
                .andExpect(status().isOk())
                .andExpect(
                        jsonPath("$._embedded." + DEPARTMENT_LOCATION + "[0].title")
                                .value(TITLE)
                );*/
    }

    /*protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }*/
}