package com.libraryapp.main.model;

import java.util.List;



import com.libraryapp.main.entity.PaymentEntity;

import lombok.Data;
@Data
public class MembershipType {
    private int membershipTypeId;
	
	private String description;
	
	private int durationMonths;
	
	private float price;
	

	private List <PaymentEntity> payments;
	

}
