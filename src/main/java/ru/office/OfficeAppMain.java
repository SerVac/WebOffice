package ru.office;


import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EntityScan("ru.office.data")
//@SpringBootApplication
//@SpringBootConfiguration
@SpringBootConfiguration
public class OfficeAppMain extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(OfficeAppMain.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}