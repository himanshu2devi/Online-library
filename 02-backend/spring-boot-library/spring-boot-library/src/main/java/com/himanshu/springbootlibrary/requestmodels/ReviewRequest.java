package com.himanshu.springbootlibrary.requestmodels;

import java.util.Optional;

public class ReviewRequest {
	
	public ReviewRequest() {}
	
	@Override
	public String toString() {
		return "ReviewRequest [rating=" + rating + ", bookId=" + bookId + ", reviewDescription=" + reviewDescription
				+ "]";
	}

	public ReviewRequest(double rating, long bookId, Optional<String> reviewDescription) {
		super();
		this.rating = rating;
		this.bookId = bookId;
		this.reviewDescription = reviewDescription;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public  long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public Optional<String> getReviewDescription() {
		return reviewDescription;
	}
	public void setReviewDescription(Optional<String> reviewDescription) {
		this.reviewDescription = reviewDescription;
	}
	private double rating;
	private  long bookId;
	private Optional<String> reviewDescription;

}
