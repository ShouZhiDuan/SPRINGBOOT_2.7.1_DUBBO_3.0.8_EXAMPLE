package com.nvclouds.medusaserver;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class MedusaServerApplication {

    public static void main(String[] args) {
        //System.setProperty("DUBBO_IP_TO_REGISTRY","192.168.50.175");
        //SpringApplication.run(MedusaServerApplication.class, args);
        SpringApplication springApplication = new SpringApplication(MedusaServerApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}