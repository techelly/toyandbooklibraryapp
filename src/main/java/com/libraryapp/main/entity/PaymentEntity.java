package com.libraryapp.main.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class PaymentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	
	@ManyToOne
	@JoinColumn(name="parentId")
	private ParentEntity parent;
	
	@ManyToOne
	@JoinColumn(name="membershipTypeId")
	private MembershipTypeEntity membershipType;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	

}
