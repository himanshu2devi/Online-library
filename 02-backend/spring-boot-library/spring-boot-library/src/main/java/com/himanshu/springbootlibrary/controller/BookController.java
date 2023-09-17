package com.himanshu.springbootlibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.himanshu.springbootlibrary.Entity.Book;
import com.himanshu.springbootlibrary.Service.BookService;
import com.himanshu.springbootlibrary.Utils.ExtractJWT;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {
	
	
	private BookService bookservice;
	
	@Autowired
	public BookController(BookService bookservice) {
		this.bookservice=bookservice;
	}
	
	@GetMapping("/secure/currentloans/count")
	public int currentLoansCount(@RequestHeader(value="Authorization") String token) {
		String userEmail=ExtractJWT.payloadJWTExtraction(token,"\"sub\"");
		return bookservice.currentLoansAccount(userEmail);
	}
	
	@PutMapping("/secure/checkout")
	public Book checkoutBook (@RequestHeader(value="Authorization") String token,
			@RequestParam Long bookId) throws Exception{
	String userEmail=ExtractJWT.payloadJWTExtraction(token,"\"sub\"");
	return bookservice.checkoutBook(userEmail,bookId);
	}
	
	@GetMapping("/secure/ischeckedout/byuser")
	public boolean checkoutBookByUser(@RequestHeader(value="Authorization") String token,
			@RequestParam Long bookId) throws Exception {
		String userEmail=ExtractJWT.payloadJWTExtraction(token,"\"sub\"");
		return bookservice.checkoutBookByUser(userEmail, bookId);
	}
}
