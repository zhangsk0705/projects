package com.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SeataAccountDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountDemoApplication.class, args);
    }

}
