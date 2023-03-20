package com.libraryapp.main.model;

import java.time.LocalDate;



import com.libraryapp.main.entity.BookEntity;
import com.libraryapp.main.entity.ToyEntity;
import com.libraryapp.main.entity.UserEntity;

import lombok.Data;
@Data
public class LendItem {
private int lendId;
	
	
	private UserEntity user;
	
	private LocalDate lendDate;
	
	private LocalDate returnDate;
	
	
	private BookEntity book;
	
	
	private ToyEntity toy;
	
	private float fine;
	
	

}
