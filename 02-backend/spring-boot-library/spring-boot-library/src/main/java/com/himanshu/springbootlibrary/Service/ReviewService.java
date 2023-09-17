package com.himanshu.springbootlibrary.Service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.himanshu.springbootlibrary.DAO.BookRepository;
import com.himanshu.springbootlibrary.DAO.ReviewRepository;
import com.himanshu.springbootlibrary.Entity.Review;
import com.himanshu.springbootlibrary.requestmodels.ReviewRequest;

@Service
@Transactional
public class ReviewService {
	
	
	
	private ReviewRepository reviewrepository;

	@Autowired
	public ReviewService( ReviewRepository reviewrepository) {
		super();
	
		this.reviewrepository = reviewrepository;
	}
	
	public void PostReview(String userEmail,ReviewRequest reviewRequest) throws Exception{
		
			Review validateReview=reviewrepository.findByUserEmailAndBookId(userEmail,reviewRequest.getBookId() );
			
			if(validateReview!=null)
			{
				throw new Exception("review already created");
			}
			
			Review review=new Review();
			review.setBookId(reviewRequest.getBookId());
			review.setRating(reviewRequest.getRating());
			review.setUserEmail(userEmail);
			
			if(reviewRequest.getReviewDescription().isPresent()) {
				review.setReviewDescription(reviewRequest.getReviewDescription().map(
						Object::toString).orElse(null));
			}
			
			review.setDate(Date.valueOf(LocalDate.now()));
			reviewrepository.save(review);
	}
			
			public boolean userReviewListed(String userEmail,Long bookId) {
				Review validateReview = reviewrepository.findByUserEmailAndBookId(userEmail, bookId);
				if(validateReview!=null) {
					return true;
				}
				else {
					return false;
				}
			}
		
	}
	
	
	
	


