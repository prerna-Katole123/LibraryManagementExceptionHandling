package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.Service.BookService;

@RestController
public class BookController {
	private BookService bs;

	public BookController(BookService bs) {
		this.bs = bs;
	}

	@PostMapping("addbook")
	public ResponseEntity<String> saveBookInfo(@RequestBody Book b) {
		bs.addBookInfo(b);
		return new ResponseEntity<String>("book added", HttpStatus.CREATED);
	}

	@GetMapping("book/id/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id) {
		Book b = bs.getBookById(id);
		return new ResponseEntity<Book>(b, HttpStatus.OK);
	}

	@GetMapping("book/authorName/{authorName}")
	public ResponseEntity<List<Book>> getBookByAuthorName(@PathVariable String authorName) {
		List<Book> a = bs.getBookByAuthorName(authorName);
		return new ResponseEntity<List<Book>>(a, HttpStatus.OK);
	}

	@GetMapping("book/name/{name}")
	public ResponseEntity<List<Book>> getBookByName(@PathVariable String name) {
		List<Book> n = bs.getBookByBookName(name);
		return new ResponseEntity<List<Book>>(n, HttpStatus.OK);
	}

	@GetMapping("books")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> l = bs.getAllBooks();
		return new ResponseEntity<>(l, HttpStatus.OK);
	}

	@DeleteMapping("deletebook")
	public ResponseEntity<Void> deleteBookById(@PathVariable int id) {
		bs.deleteBookInfoById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
