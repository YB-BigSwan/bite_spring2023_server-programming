package com.example.bookstore_swanson.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookstoreRepository extends CrudRepository<Book, Long>{

	List<Book> findByTitle(String title);

}
