package com.libraryapp.main.model;

import java.util.List;


import com.libraryapp.main.entity.LendItemEntity;
import com.libraryapp.main.entity.ParentEntity;

import lombok.Data;
@Data

public class User {
private int userId;
	
	private String userName;
	
	private String password;
	
	private String mobile;
	
	private String address;
	
	private String email;
	
	private String gender;
	
	private String role;
	
	
	private ParentEntity parent;
	

	private List<LendItemEntity> lendItems;
	


}
