package com.libraryapp.main.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Data
@Entity

public class MembershipTypeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int membershipTypeId;
	
	private String description;
	
	private int durationMonths;
	
	private float price;
	
	@OneToMany(mappedBy = "membershipType")
	private List <PaymentEntity> payments;
	
	

}
