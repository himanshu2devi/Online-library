package com.himanshu.springbootlibrary.Entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name="book")
@Data
public class Book {
	
	public Book() {}
	
	public Book(long id, String title, String author, String description, int copies, int copiesAvailable,
			String category, String img) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.description = description;
		this.copies = copies;
		this.copiesAvailable = copiesAvailable;
		this.category = category;
		this.img = img;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", copies=" + copies + ", copiesAvailable=" + copiesAvailable + ", category=" + category + ", img="
				+ img + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public int getCopiesAvailable() {
		return copiesAvailable;
	}

	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="author")
	private String author;
	
	@Column(name="description")
	private String description;
	
	@Column(name="copies")
	private int copies;
	
	@Column(name="copies_available")
	private int copiesAvailable;
	
	@Column(name="category")
	private String category;
	
	@Column(name="img")
	private String img;
	

}
