package com.libraryapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libraryapp.main.entity.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

}
