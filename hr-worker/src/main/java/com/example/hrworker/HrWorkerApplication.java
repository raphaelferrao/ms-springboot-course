package com.example.hrworker;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableEurekaClient
@SpringBootApplication
public class HrWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrWorkerApplication.class, args);
	}
	
	@PostConstruct
	public void afterStart() {
		log.info("****** HR-WORKER STARTED ******");
	}
	
	@PreDestroy
	public void beforeStop() {
		log.info("****** HR-WORKER STOPPED ******");
	}

}
