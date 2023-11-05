package com.example.bookstore_swanson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.bookstore_swanson.domain.Book;
import com.example.bookstore_swanson.domain.BookstoreRepository;
import com.example.bookstore_swanson.domain.CategoryRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookstoreSwansonRepositoryTests {

	@Autowired
	private BookstoreRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testBookListEndpoint() {
        String baseUrl = restTemplate.getRootUri() + "/books";
        
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Test
    public void testCreateBook() {
        Book book = new Book("Test Book", "Test Author", "2023", "1234567890", 19.99, crepository.findByName("Biography").get(0));
        Book savedBook = repository.save(book);
        assertEquals(book.getTitle(), savedBook.getTitle());
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book("Test Book", "Test Author", "2023", "1234567890", 19.99, crepository.findByName("Biography").get(0));
        Book savedBook = repository.save(book);
        repository.deleteById(savedBook.getBookId());
        assertEquals(0, repository.count());
    }

    @Test
    public void testSearchBook() {
        Book book = new Book("Search Me", "Author", "2023", "9876543210", 29.99, crepository.findByName("Biography").get(0));
        repository.save(book);
        Book foundBook = repository.findByTitle("Search Me").get(0);
        assertEquals("Search Me", foundBook.getTitle());
    }
}
