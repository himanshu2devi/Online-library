package com.himanshu.springbootlibrary.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.himanshu.springbootlibrary.Entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
//	
//	Page<Review> findBookById(@RequestParam("book_id") Long bookId,Pageable pageable);
	 Page<Review> findByBookId(@RequestParam("Book_id") Long bookId,
             Pageable pageable);
	
	Review findByUserEmailAndBookId(String userEmail,Long bookId);

}
