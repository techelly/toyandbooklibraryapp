package com.libraryapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryapp.main.entity.PaymentEntity;

public interface IPaymentRepository extends JpaRepository<PaymentEntity, Integer>{

}
