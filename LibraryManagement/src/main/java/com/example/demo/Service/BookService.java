package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Exception.BookSerException;
import com.example.demo.Repo.BookRepo;


@Service
public class BookService {
	private BookRepo br;

	public BookService(BookRepo br) {
		this.br = br;
	}

	public void addBookInfo(Book b) {
		if (b.getPages() > 1000) {
			throw new BookSerException("invalid data", HttpStatus.BAD_REQUEST);
		}
		br.save(b);
	}

	public Book getBookById(int id) {
		Optional<Book> o = br.findById(id);
		if (o.isEmpty()) {
			throw new BookSerException("no content ", HttpStatus.NO_CONTENT);
		}
		return o.get();
	}

	public List<Book> getAllBooks() {
		return br.findAll();
	}

	public List<Book> getBookByAuthorName(String authorName) {
		if (authorName.length() > 15) {
			throw new BookSerException("author name is not valid", HttpStatus.NOT_ACCEPTABLE);
		}
		return br.findByAuthorName(authorName);
	}

	public List<Book> getBookByBookName(String name) {
		if (name.length() > 20) {
			throw new BookSerException("book not available ", HttpStatus.BAD_REQUEST);
		}
		return br.findByName(name);
	}

	public void deleteBookInfoById(int id) {
		br.deleteById(id);
	}

}
