package com.ideaincubator.sprinkler.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WalkTheCityWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(ApplicationConfig.class, WebMvcConfig.class);
        //webApplicationContext.refresh();
        Dynamic dynamc = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(webApplicationContext));
        dynamc.addMapping("/api/v1/*");
        dynamc.setLoadOnStartup(1);
    }

}
