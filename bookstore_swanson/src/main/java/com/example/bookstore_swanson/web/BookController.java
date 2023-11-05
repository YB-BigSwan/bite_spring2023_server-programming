package com.example.bookstore_swanson.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookstore_swanson.domain.Book;
import com.example.bookstore_swanson.domain.BookstoreRepository;
import com.example.bookstore_swanson.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookstoreRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

	@GetMapping("/booklist")
	public String getBooks(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username = authentication.getName();
	    
		model.addAttribute("username", username);
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@GetMapping("/books")
	public @ResponseBody List<Book> bookListRest(){
		return (List<Book>) repository.findAll();
	}
	
	@GetMapping("/book/{id}")
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId){
		return repository.findById(bookId);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/add") 
	public String addBooks(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model Model) {
		repository.deleteById(id);
		return "redirect:../booklist";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
}
