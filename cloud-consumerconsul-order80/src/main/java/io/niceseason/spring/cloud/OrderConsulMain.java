package io.niceseason.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain.class, args);
    }
}
