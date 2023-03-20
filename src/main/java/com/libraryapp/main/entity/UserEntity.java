package com.libraryapp.main.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data

public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String userName;
	
	private String password;
	
	private String mobile;
	
	private String address;
	
	private String email;
	
	private String gender;
	
	private String role;
	
	@ManyToOne
	@JoinColumn(name="parent_id",nullable = false)
	private ParentEntity parent;
	
	@OneToMany(mappedBy = "user")
	private List<LendItemEntity> lendItems;
	

}
