package com.libraryapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryapp.main.entity.ToyEntity;

public interface IToyRepository extends JpaRepository<ToyEntity, Integer>{

}
