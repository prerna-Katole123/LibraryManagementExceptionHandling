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

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

@RestController
public class UserController {

	private UserService us;

	public UserController(UserService us) {
		this.us = us;
	}

	@PostMapping("user")
	public ResponseEntity<String> saveUserInfo(@RequestBody User u) {
		us.addUserInfo(u);
		return new ResponseEntity<String>("user added", HttpStatus.CREATED);
	}

	@GetMapping("getuser/id/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User u = us.getUserById(id);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}

	@GetMapping("users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> l=us.getAllUsers();
		return new ResponseEntity<>(l,HttpStatus.OK);
	}

	@GetMapping("getuser/mobileNo/{mobileNo}")
	public ResponseEntity<List<User>> getUserByMobileNo(@PathVariable String mobileNo) {
		List<User> m=us.getUserByMobileNo(mobileNo);
		return new ResponseEntity<>(m,HttpStatus.OK);
	}

	@GetMapping("getuser/name/{name}")
	public ResponseEntity<List<User>> getUserByName(@PathVariable String name) {
	List<User>	n=us.getUserByName(name);
		return new ResponseEntity<>(n,HttpStatus.OK);

	}

	@DeleteMapping("deleteuser")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		us.deleteUserById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
