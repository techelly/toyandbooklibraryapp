package com.libraryapp.main.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class ParentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parentId;
	
	private String name;
	
	private String cardNo;
	
	private String upiNo;
	
	@OneToMany(mappedBy = "parent")
	private Set<UserEntity> users;
	
	@OneToOne
	private MembershipTypeEntity membershipType;
	
	@OneToMany(mappedBy = "parent")
	private List<PaymentEntity> payments;
	
	

}
