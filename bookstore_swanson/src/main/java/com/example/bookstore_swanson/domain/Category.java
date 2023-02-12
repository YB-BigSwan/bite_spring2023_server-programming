package com.example.bookstore_swanson.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;

	public Category() {
	};

	public Category(String name) {
		super();
		this.name = name;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
