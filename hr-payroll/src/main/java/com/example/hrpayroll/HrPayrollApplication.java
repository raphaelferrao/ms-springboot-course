package com.example.hrpayroll;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableFeignClients
@RibbonClient("hr-worker")
@SpringBootApplication
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

	@PostConstruct
	public void afterStart() {
		log.info("****** HR-PAYROLL STARTED ******");
	}
	
	@PreDestroy
	public void beforeStop() {
		log.info("****** HR-PAYROLL STOPPED ******");
	}
	
}
