package com.libraryapp.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryapp.main.entity.PaymentEntity;
import com.libraryapp.main.entity.UserEntity;
import com.libraryapp.main.exception.ResourceNotFoundException;
import com.libraryapp.main.model.Payment;
import com.libraryapp.main.model.User;
import com.libraryapp.main.repository.IPaymentRepository;

@Service
public class PaymentService implements IPaymentService {
	@Autowired
	private IPaymentRepository paymentRepository;

	@Override
	public Payment savePayment(Payment payment) {
		// TODO Auto-generated method stub

		// convert payment model to payment entity
		PaymentEntity paymentEntity = new PaymentEntity();
		BeanUtils.copyProperties(payment, paymentEntity);

		PaymentEntity newPaymentEntity = paymentRepository.save(paymentEntity);

		// convert product entity to product model
		Payment newPayment = new Payment();
		BeanUtils.copyProperties(newPaymentEntity, newPayment);

		return newPayment;
	}

	@Override
	public Payment viewPaymentById(int paymentId) {
		// TODO Auto-generated method stub
		Optional<PaymentEntity> optionalPayment = paymentRepository.findById(paymentId);

		if (!optionalPayment.isPresent()) {
			throw new ResourceNotFoundException("Payment not existing with id: " + paymentId);
		}

		PaymentEntity paymentEntity = optionalPayment.get();

		// convert product entity to product model
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentEntity, payment);

		return payment;

	}

	@Override
	public List<Payment> viewAllPayments() {
		// TODO Auto-generated method stub

		List<PaymentEntity> paymentEntities = paymentRepository.findAll();

		// convert product entity list to product list
		List<Payment> payments = new ArrayList<>();

		paymentEntities.forEach(pentity -> {
			Payment payment = new Payment();
			BeanUtils.copyProperties(pentity, payment);
			payments.add(payment);
		});

		return payments;

	}

}
