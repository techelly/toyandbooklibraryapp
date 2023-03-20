package com.libraryapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryapp.main.entity.ParentEntity;

public interface IParentRepository extends JpaRepository<ParentEntity, Integer>{

}
