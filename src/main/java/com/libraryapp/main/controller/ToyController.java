package com.libraryapp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.libraryapp.main.model.Toy;
import com.libraryapp.main.service.IToyService;

@RestController
public class ToyController {

	@Autowired
	private IToyService toyService;

	@PostMapping("/toy/save")
	public ResponseEntity<Toy> addToy(@RequestBody Toy toy) {
		Toy newToy = toyService.saveToy(toy);
		ResponseEntity<Toy> responseEntity = new ResponseEntity<>(newToy, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/toy/{toyId}")
	public ResponseEntity<Toy> getToy(@PathVariable("toyId") int toyId) {
		Toy toy = toyService.viewtoyById(toyId);
		ResponseEntity<Toy> responseEntity = new ResponseEntity<>(toy, HttpStatus.OK);
		return responseEntity;

	}

	@GetMapping("/toy/all")
	public List<Toy> getAllToys() {
		List<Toy> toys = toyService.viewAllToys();
		return toys;
	}

}
