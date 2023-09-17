package com.himanshu.springbootlibrary.Service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.himanshu.springbootlibrary.DAO.BookRepository;
import com.himanshu.springbootlibrary.DAO.CheckoutRepository;
import com.himanshu.springbootlibrary.Entity.Book;
import com.himanshu.springbootlibrary.Entity.Checkout;

@Service
@Transactional
public class BookService {
	
	private BookRepository bookrepository;
	
	private CheckoutRepository checkoutrepository;
	
	public BookService(BookRepository bookrepository,CheckoutRepository checkoutrepository) {
		this.bookrepository=bookrepository;
		this.checkoutrepository=checkoutrepository;
	}
	
	public Book checkoutBook(String userEmail,Long bookId) throws Exception{
		Optional<Book> book = bookrepository.findById(bookId);
		Checkout validatecheckout = checkoutrepository.findByUserEmailAndBookId(userEmail, bookId);
		
		if(!book.isPresent() || validatecheckout!=null || book.get().getCopiesAvailable()<=0) {
			throw new Exception("Book does not exist or already checkedout by user");
		}
		book.get().setCopiesAvailable(book.get().getCopiesAvailable()-1);
		bookrepository.save(book.get());
		
		Checkout checkout=new Checkout(userEmail,
				LocalDate.now().toString(),
				LocalDate.now().plusDays(7).toString(),
				book.get().getId());
		
		checkoutrepository.save(checkout);
		return book.get();
		
	}
	
	public Boolean checkoutBookByUser(String userEmail,Long bookId) {
		Checkout validatecheckout = checkoutrepository.findByUserEmailAndBookId(userEmail, bookId);
		if(validatecheckout != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int currentLoansAccount(String userEmail) {
		return checkoutrepository.findBooksByUserEmail(userEmail).size();
	}

}
