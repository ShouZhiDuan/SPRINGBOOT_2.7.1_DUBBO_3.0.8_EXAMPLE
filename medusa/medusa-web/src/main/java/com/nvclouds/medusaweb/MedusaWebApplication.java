package com.nvclouds.medusaweb;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class MedusaWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedusaWebApplication.class, args);
    }

}
