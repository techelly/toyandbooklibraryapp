package com.libraryapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryapp.main.entity.BookEntity;

public interface IBookRepository extends JpaRepository<BookEntity, Integer> {

}
