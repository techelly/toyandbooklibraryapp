package com.libraryapp.main.service;

import java.util.List;

import com.libraryapp.main.model.Payment;

public interface IPaymentService {
	
	public Payment savePayment(Payment payment);
	
	public  Payment viewPaymentById(int paymentId );

	public List<Payment> viewAllPayments();
}
