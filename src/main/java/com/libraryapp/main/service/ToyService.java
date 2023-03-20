package com.libraryapp.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryapp.main.entity.ToyEntity;
import com.libraryapp.main.exception.ResourceNotFoundException;
import com.libraryapp.main.model.Toy;
import com.libraryapp.main.repository.IToyRepository;

@Service
public class ToyService implements IToyService {

	@Autowired
	private IToyRepository toyRepository;

	@Override
	public Toy saveToy(Toy toy) {
		ToyEntity toyEntity = new ToyEntity();
		BeanUtils.copyProperties(toy, toyEntity);

		ToyEntity newToyEntity = toyRepository.save(toyEntity);

		Toy newToy = new Toy();
		BeanUtils.copyProperties(newToyEntity, newToy);

		return newToy;
	}

	@Override
	public Toy viewtoyById(int toyId) {
		Optional<ToyEntity> optionalToy = toyRepository.findById(toyId);
		if (!optionalToy.isPresent()) {
			throw new ResourceNotFoundException("Toy not existing with id: " + toyId);
		}
		ToyEntity toyEntity = optionalToy.get();

		// convert product entity to product model
		Toy toy = new Toy();
		BeanUtils.copyProperties(toyEntity, toy);
		return toy;
	}

	@Override
	public List<Toy> viewAllToys() {
		List<ToyEntity> toyEntities = toyRepository.findAll();

		// convert product entity list to product list
		List<Toy> toys = new ArrayList<>();

		toyEntities.forEach(tentity -> {
			Toy toy = new Toy();
			BeanUtils.copyProperties(tentity, toy);
			toys.add(toy);
		});
		return toys;
	}

}
