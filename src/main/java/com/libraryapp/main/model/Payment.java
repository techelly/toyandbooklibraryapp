package com.libraryapp.main.model;

import java.time.LocalDate;


import com.libraryapp.main.entity.MembershipTypeEntity;
import com.libraryapp.main.entity.ParentEntity;

import lombok.Data;
@Data
public class Payment {
private int paymentId;
	

	private ParentEntity parent;
	
	
	private MembershipTypeEntity membershipType;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	


}
