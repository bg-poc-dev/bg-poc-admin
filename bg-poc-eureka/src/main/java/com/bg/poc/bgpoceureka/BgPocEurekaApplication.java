package com.bg.poc.bgpoceureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BgPocEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgPocEurekaApplication.class, args);
    }
}
