package com.ideaincubator.sprinkler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 import org.springframework.web.servlet.view.json.MappingJacksonJsonView; 
//import org.springframework.web.servlet.config.annotation.CorsRegistry;


import com.ideaincubator.sprinkler.rest.PingResource;

@EnableWebMvc
@ComponentScan(basePackageClasses = PingResource.class)
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public MappingJacksonJsonView jsonView() {
    	MappingJacksonJsonView jsonView = new MappingJacksonJsonView();
        jsonView.setPrefixJson(true);
        return jsonView;
    }
    
 /*   @Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
			.allowedOrigins("*")
			.allowedMethods("PUT", "DELETE")
			.allowedHeaders("contentType", "header2", "header3")
			//.exposedHeaders("header1", "header2")
			.allowCredentials(false).maxAge(3600);
	}*/
}
