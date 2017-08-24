package ru.office;


import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import ru.office.config.DatabaseManagerSwingThread;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

//@Configuration
@EnableAutoConfiguration
//@ComponentScan
@EntityScan("ru.office.data")
@SpringBootApplication
//@SpringBootConfiguration
public class OfficeAppMain extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.headless(false);
        application.bannerMode(Banner.Mode.OFF);
        return application.sources(OfficeAppMain.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        //HSQL manager
        (new DatabaseManagerSwingThread()).start();

    }

}