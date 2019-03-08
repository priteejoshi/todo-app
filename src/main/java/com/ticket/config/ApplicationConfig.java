package com.ticket.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebSecurity
public class ApplicationConfig extends WebSecurityConfigurerAdapter  {
	private static String REALM="MY_TEST_REALM";
    @Autowired
private BasicAuthenticationPoint basicAuthenticationPoint;

    
    @Bean
    public Docket api() {
    	System.out.println("api");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ticket.service"))
                .paths(PathSelectors.any())
                .build();
    }

    

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable()
       .authorizeRequests()
       .antMatchers("/", "/hello/**").permitAll().anyRequest().authenticated()
       .and().httpBasic().realmName(REALM).authenticationEntryPoint(basicAuthenticationPoint)
    .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //http.addFilterAfter(new CustomFilter(),
           //     BasicAuthenticationFilter.class);

    }
    /* To allow Pre-flight [OPTIONS] request from browser 
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }*/

    private ApiInfo getApiInfo() {
        Contact contact = new Contact("Naga Sree", "", "nagasree@techmahindra.com");
        return new ApiInfoBuilder()
                .title("Example Api Title")
                .description("Example Api Definition")
                .version("1.0.0")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	
      //  auth.inMemoryAuthentication().withUser("naga").password("sree").roles("USER");
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
          .withUser("tactix")
          .password(encoder.encode("Tactix@123"))
          .roles("USER");
         encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
          .withUser("knowledgeworks")
          .password(encoder.encode("KW@123"))
          .roles("USER");
    }
    
}
