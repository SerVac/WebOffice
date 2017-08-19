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
//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(OfficeAppMain.class, args);
//    }

 /*
   public static void main1(String[] args) throws Exception {
//        ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).headless(false).run(args);
        ConfigurableApplicationContext context = new SpringApplicationBuilder(
                OfficeAppMain.class).headless(false).run(args);
        Swing appFrame = context.getBean(Swing.class);
        appFrame.startDBManager();
//        AppPrincipalFrame appFrame = context.getBean(AppPrincipalFrame.class);
//        SpringApplication app = new SpringApplication(OfficeAppMain.class);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);
    }*/

}