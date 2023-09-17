package com.himanshu.springbootlibrary.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="checkout")
public class Checkout {

	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_email")
	private String userEmail;
	
	public Checkout(String userEmail, String checkoutDate, String returnDate, Long bookId) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		CheckoutDate = checkoutDate;
		this.returnDate = returnDate;
		this.bookId = bookId;
	}
	
	public Checkout() {}

	

	@Override
	public String toString() {
		return "Checkout [id=" + id + ", userEmail=" + userEmail + ", CheckoutDate=" + CheckoutDate + ", returnDate="
				+ returnDate + ", bookId=" + bookId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getuserEmail() {
		return userEmail;
	}

	public void setuserEmail(String userEmail) {
		userEmail = userEmail;
	}

	public String getCheckoutDate() {
		return CheckoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		CheckoutDate = checkoutDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	@Column(name="checkout_date")
	private String CheckoutDate;
	
	@Column(name="return_date")
	private String returnDate;
	
	@Column(name="book_id")
	private Long bookId;
}
