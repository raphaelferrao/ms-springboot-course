package com.example.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.example.hrpayroll.entities.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Override
	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Bob", 200.0, days);
	}
	
}
