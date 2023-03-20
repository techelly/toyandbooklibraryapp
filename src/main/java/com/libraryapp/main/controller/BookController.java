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

import com.libraryapp.main.model.Book;
import com.libraryapp.main.service.IBookService;

@RestController
public class BookController {
	@Autowired
	private IBookService bookService;

	@PostMapping("/book/save")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book newBook = bookService.saveBook(book);
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(newBook, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/book/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable("bookId") int bookId) {
		Book book = bookService.findBookById(bookId);
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(book, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/book/all")
	public List<Book> getAllBook() {
		List<Book> books = bookService.findAllBooks();
		return books;
	}

}
