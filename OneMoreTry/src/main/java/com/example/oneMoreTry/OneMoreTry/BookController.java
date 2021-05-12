package com.example.oneMoreTry.OneMoreTry;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

@RestController
public class BookController {
	private static Logger logger=LoggerFactory.getLogger(BookController.class);

	@Autowired
	BookService bookServicek;
	
	@GetMapping("/books")
	public List<Book> getAllBooks()
	{
		return bookServicek.getAllBooks();
	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable int id)
	{
		
		return bookServicek.getBook(id);
	}
	
	
	@PostMapping("/saveBook")
	public void saveBook(@RequestBody Book book)
	{
		logger.info("Save Book API Called");
		bookServicek.insertBook(book);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id)
	{
		return bookServicek.deletetBook(id);
	}
	
	@PutMapping("/book/{id}")
	public String updateBook(@PathVariable int id,@RequestBody Book book)
	{
		return bookServicek.updateBook(id, book);
	}
	
	@GetMapping("/pranav")
	public String name()
	{
		return "Hello Pranav";
	}
	
	
}
