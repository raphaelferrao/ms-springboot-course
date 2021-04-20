package com.example.hreurekaserver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class HrEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrEurekaServerApplication.class, args);
	}
	
	@PostConstruct
	public void afterStart() {
		log.info("****** HR-EUREKA-SERVER STARTED ******");
	}
	
	@PreDestroy
	public void beforeStop() {
		log.info("****** HR-EUREKA-SERVER STOPPED ******");
	}

}
