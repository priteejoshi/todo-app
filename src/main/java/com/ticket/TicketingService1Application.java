
package com.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableMongoRepositories("com.ticket.repository")
@EnableSwagger2
public class TicketingService1Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TicketingService1Application.class, args);
	}
	@Configuration
    public class CorsConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
        	
            registry.addMapping("/tickets/**")
                    .allowedOrigins("http://localhost:8000")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
//                    .allowCredentials(true)
            
        }

	}
	}
