package com.example.bookstore_swanson.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bookstore_swanson.domain.Book;
import com.example.bookstore_swanson.domain.BookstoreRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookstoreRepository repository;

	@GetMapping("/booklist")
	public String getBooks(Model model) {	
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@GetMapping("/add") 
	public String addBooks(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model Model) {
		repository.deleteById(id);
		return "redirect:../booklist";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		return "editbook";
	}
	
}
