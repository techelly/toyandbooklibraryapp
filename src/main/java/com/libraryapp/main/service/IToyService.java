package com.libraryapp.main.service;

import java.util.List;

import com.libraryapp.main.model.Toy;

public interface IToyService {
	
	public Toy saveToy(Toy toy);
	
	public Toy viewtoyById(int toyId);
	
	public List<Toy> viewAllToys();

}
