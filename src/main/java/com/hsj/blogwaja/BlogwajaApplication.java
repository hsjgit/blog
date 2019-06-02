package com.hsj.blogwaja;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author waja
 */
@MapperScan("com.hsj.blogwaja.dao")
@SpringBootApplication
public class BlogwajaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogwajaApplication.class, args);
    }

}
