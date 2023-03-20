package com.libraryapp.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryapp.main.entity.BookEntity;
import com.libraryapp.main.exception.ResourceNotFoundException;
import com.libraryapp.main.model.Book;
import com.libraryapp.main.repository.IBookRepository;

@Service
public class BookService implements IBookService{
	@Autowired
	private IBookRepository bookRepository;

	@Override
	public Book saveBook(Book book) {
		//convert book model to book entity
		
		BookEntity bookEntity=new BookEntity();
		BeanUtils.copyProperties(book,bookEntity);
		
		BookEntity newBookEntity=bookRepository.save(bookEntity);
		//covert book entity to book model
		
		Book newBook=new Book();
		BeanUtils.copyProperties(newBookEntity,newBook);
		
		return newBook;
	}

	@Override
	public Book findBookById(int bookId) {
		Optional<BookEntity> optionalBook = bookRepository.findById(bookId);
		if(!optionalBook.isPresent()) {
			throw new ResourceNotFoundException("Book not existing with id:"+bookId);
		}
		BookEntity bookEntity=optionalBook.get();
		//convert book entity to book model
		Book book=new Book();
		BeanUtils.copyProperties(bookEntity, book);
		return book;
	}

	@Override
	public List<Book> findAllBooks() {
		List<BookEntity> bookEntities=bookRepository.findAll();
		//convert book entity list to book list
		List<Book>books=new ArrayList<>();
		bookEntities.forEach(pentity->{
			Book book=new Book();
			BeanUtils.copyProperties(pentity, book);
			books.add(book);
		});
		return books;
	}

}
