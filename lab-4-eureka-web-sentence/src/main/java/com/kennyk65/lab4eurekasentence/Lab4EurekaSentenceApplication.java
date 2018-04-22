package com.kennyk65.lab4eurekasentence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lab4EurekaSentenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab4EurekaSentenceApplication.class, args);
    }
}
