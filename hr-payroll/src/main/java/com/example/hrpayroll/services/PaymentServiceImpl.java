package com.example.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.entities.Worker;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Value("${hr-worker.host}")
	private String hrWorkerHost;

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Payment getPayment(Long workerId, Integer days) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", workerId.toString());
		
		String url = String.format("%s/workers/{id}", hrWorkerHost);
		
		Worker worker = restTemplate.getForObject(url, Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
