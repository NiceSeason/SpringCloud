package io.niceseason.spring.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //必须添加此注解，否则java.net.UnknownHostException: CLOUD-PAYMENT-SERVICE
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
