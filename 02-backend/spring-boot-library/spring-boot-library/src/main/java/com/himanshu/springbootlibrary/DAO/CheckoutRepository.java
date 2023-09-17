package com.himanshu.springbootlibrary.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himanshu.springbootlibrary.Entity.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Long>{
	
	Checkout findByUserEmailAndBookId(String userEmail,Long bookId);
	List<Checkout> findBooksByUserEmail(String userEmail);
	

}
