package com.libraryapp.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ToyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int toyId;
	
	private String name;
	
	private float price;
	
	private String company;
	
	private String category;
	
	

}
