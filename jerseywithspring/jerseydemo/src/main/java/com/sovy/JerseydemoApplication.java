package com.sovy;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableAutoConfiguration
public class JerseydemoApplication
        extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new JerseydemoApplication().configure(new SpringApplicationBuilder(JerseydemoApplication.class)).run(args);

        //SpringApplication.run(Application.class, args);
    }

}
