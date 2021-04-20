package com.example.hrconfigserver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableConfigServer
@SpringBootApplication
public class HrConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}
	
	@PostConstruct
	public void afterStart() {
		log.info("****** HR-CONFIG-SERVER STARTED ******");
	}
	
	@PreDestroy
	public void beforeStop() {
		log.info("****** HR-CONFIG-SERVER STOPPED ******");
	}

}
