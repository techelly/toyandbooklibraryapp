package com.libraryapp.main.service;

import java.util.List;

import com.libraryapp.main.model.Book;

public interface IBookService {
	public Book saveBook(Book book);
	public Book findBookById(int bookId);
	public List<Book> findAllBooks();
	

}
