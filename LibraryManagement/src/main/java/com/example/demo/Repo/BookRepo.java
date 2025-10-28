package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Book;
import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer> {
	List<Book> findByAuthorName(String authorName);

	List<Book> findByName(String name);

}
