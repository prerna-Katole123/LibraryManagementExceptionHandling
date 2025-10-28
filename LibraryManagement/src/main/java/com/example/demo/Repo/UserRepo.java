package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.User;
import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
	List<User> findByMobileNo(String mobileNo);

	List<User> findByName(String name);
}
