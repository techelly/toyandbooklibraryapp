package com.libraryapp.main.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class LendItemEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lendId;
	
	@ManyToOne
	private UserEntity user;
	
	private LocalDate lendDate;
	
	private LocalDate returnDate;
	
	@OneToOne
	@JoinColumn(name="bookId")
	private BookEntity book;
	
	@OneToOne
	@JoinColumn(name="toyId")
	private ToyEntity toy;
	
	private float fine;
	
	
	

	

}
