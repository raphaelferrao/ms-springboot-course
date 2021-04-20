package com.example.hrapigatewayzuul;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class HrApiGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApiGatewayZuulApplication.class, args);
	}

	@PostConstruct
	public void afterStart() {
		log.info("****** HR-API-GATEWAY-ZUUL STARTED ******");
	}
	
	@PreDestroy
	public void beforeStop() {
		log.info("****** HR-API-GATEWAY-ZUUL STOPPED ******");
	}
	
}
