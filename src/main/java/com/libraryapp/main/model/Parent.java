package com.libraryapp.main.model;

import java.util.List;
import java.util.Set;


import com.libraryapp.main.entity.MembershipTypeEntity;
import com.libraryapp.main.entity.PaymentEntity;
import com.libraryapp.main.entity.UserEntity;

import lombok.Data;
@Data
public class Parent {
private int parentId;
	
	private String name;
	
	private String cardNo;
	
	private String upiNo;
	
	
	private Set<UserEntity> users;
	
	
	private MembershipTypeEntity membershipType;
	
	
	private List<PaymentEntity> payments;
	

}
