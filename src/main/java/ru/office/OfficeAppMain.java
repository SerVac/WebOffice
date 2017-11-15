package ru.office;


import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import ru.office.config.DatabaseManagerSwingThread;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

//@Configuration
@EnableAutoConfiguration
@EntityScan({"ru.office.data"})
@SpringBootApplication
//@SpringBootConfiguration
/*@ComponentScan(basePackages = {
        "ru.office.service",
        "ru.office.web"
})*/
@ComponentScan({"ru.office","ru.office.service"})
public class OfficeAppMain extends SpringBootServletInitializer {
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