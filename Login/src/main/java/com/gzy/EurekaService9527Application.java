package com.gzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication(scanBasePackages = { "com.gzy.web.controller","com.gzy.service"})
@MapperScan("com.gzy.dao")
@EnableDiscoveryClient

public class EurekaService9527Application {
    public static void main(String[] args) {
        SpringApplication.run (EurekaService9527Application.class,args );
    }
}
