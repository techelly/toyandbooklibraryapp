package com.libraryapp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.libraryapp.main.model.Payment;
import com.libraryapp.main.service.IPaymentService;

@RestController
public class PaymentController {
	@Autowired
	private IPaymentService paymentService;

	@PostMapping("/payment/save")
	public ResponseEntity<Payment> doPayment(@RequestBody Payment payment) {
		Payment newPayment = paymentService.savePayment(payment);
		ResponseEntity<Payment> responseEntity = new ResponseEntity<>(newPayment, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/payment/{paymentId}")
	public ResponseEntity<Payment> getPayment(@PathVariable("paymentId") int paymentId) {
		Payment payment = paymentService.viewPaymentById(paymentId);
		ResponseEntity<Payment> responseEntity = new ResponseEntity<>(payment, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/payment/all")
	public List<Payment> getAllPayments() {
		List<Payment> payments = paymentService.viewAllPayments();
		return payments;
	}

}
