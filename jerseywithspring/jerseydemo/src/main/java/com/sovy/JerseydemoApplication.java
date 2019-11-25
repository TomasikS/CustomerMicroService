package com.sovy;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class JerseydemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new JerseydemoApplication().configure(new SpringApplicationBuilder(JerseydemoApplication.class)).run(args);
    }

//    @Bean
//public DataSource dataSource(){
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    dataSource.setDriverClassName("org.postgresql.Driver");
//    dataSource.setUrl("jdbc:postgresql://localhost:5432/bookstore");
//    dataSource.setUsername( "postgres" );
//    dataSource.setPassword( "postgres" );
//    return dataSource;
//}
}
