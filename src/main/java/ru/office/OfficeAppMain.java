package ru.office;


import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.office.config.DatabaseManagerSwingThread;
import ru.office.dao.repository.DepartmentRepository;

import javax.annotation.PostConstruct;

//@Configuration
//@EnableAutoConfiguration()
@EntityScan(basePackages = {"ru.office.data.entity"})
@EnableJpaRepositories(basePackageClasses = {
        DepartmentRepository.class
})
@SpringBootApplication
//@SpringBootConfiguration
@ComponentScan(basePackages = {
        "ru.office",
        "ru.office.service"
})
//@ComponentScan({"ru.office", "ru.office.service"})
public class OfficeAppMain extends SpringBootServletInitializer {

    public static final String ENCODING = "UTF-8";

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.headless(false);
        application.bannerMode(Banner.Mode.OFF);
        return application.sources(OfficeAppMain.class);
    }

    @PostConstruct
    public void afterInit() {
        //HSQL manager
        (new DatabaseManagerSwingThread()).start();
    }

   /* @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        dataSource.setUrl("jdbc:hsqldb:mem:web-office-db");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        // schema init
//        Resource initSchema = new ClassPathResource("scripts/schema-h2.sql");
        Resource initData = new ClassPathResource("/data-hsqldb-1.sql");
//        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initData);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);

        return dataSource;
    }*/
}