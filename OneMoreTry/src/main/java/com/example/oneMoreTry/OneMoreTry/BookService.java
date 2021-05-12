package com.example.oneMoreTry.OneMoreTry;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	private static Logger logger=LoggerFactory.getLogger(BookService.class);

	@Autowired
	BookRepository bookRepo;
	
	public List<Book> getAllBooks()
	{
		return bookRepo.getAllBooks();
	}
	
	
	public Book getBook(int id)
	{
		return bookRepo.getBookById(id);
		
	}
	
	
	
	public void insertBook(Book book)
	{
		logger.info("Inside the Service Class: Insert Book Method");
		bookRepo.insertBook(book);
	}
	
	public String deletetBook(int id)
	{
		return bookRepo.deleteBook(id);
	}
	
	public String updateBook(int id, Book book)
	{
		return bookRepo.updateBook(id, book);
	}
	
}
