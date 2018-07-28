package ru.office;


import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.office.config.DatabaseManagerSwingThread;

import javax.annotation.PostConstruct;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "ru.office")
@EntityScan(basePackages = {"ru.office.entity"})
@ComponentScan(basePackages = {
        "ru.office",
        "ru.office.service"
})
@EnableJpaRepositories(basePackages = "ru.office.dao.repository")
@PropertySource(value = {"classpath:/application.properties"}, encoding = "UTF-8")
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.headless(false);
        application.bannerMode(Banner.Mode.OFF);
        return application.sources(Application.class);
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