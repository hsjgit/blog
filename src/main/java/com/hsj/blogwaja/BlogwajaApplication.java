package com.hsj.blogwaja;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

/**
 * @author waja
 */
@MapperScan("com.hsj.blogwaja.dao")
@SpringBootApplication
public class BlogwajaApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){

        return application.sources(BlogwajaApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(BlogwajaApplication.class, args);
    }

}
