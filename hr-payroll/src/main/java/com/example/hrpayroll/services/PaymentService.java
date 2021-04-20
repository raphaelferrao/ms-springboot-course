package com.example.hrpayroll.services;

import com.example.hrpayroll.entities.Payment;

public interface PaymentService {

	Payment getPayment(Long workerId, Integer days);

}