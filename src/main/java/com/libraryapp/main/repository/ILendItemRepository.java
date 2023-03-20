package com.libraryapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryapp.main.entity.LendItemEntity;

public interface ILendItemRepository extends JpaRepository<LendItemEntity, Integer>{

}
