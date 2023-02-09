package com.example.bookstore_swanson.domain;

public class Book {
	
	private String title;
	private String author;
	private String publicationYear;
	private String isbn;
	private Double price;
	
	public Book (String title, String author, String publicationYear, String isbn, Double price) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
		this.price = price;
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

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	

}
