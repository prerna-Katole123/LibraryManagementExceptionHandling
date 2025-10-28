package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Exception.UserSerException;
import com.example.demo.Repo.UserRepo;

@Service
public class UserService {
	private UserRepo ur;

	public UserService(UserRepo ur) {
		this.ur = ur;
	}

	public void addUserInfo(User u) {
		ur.save(u);
	}

	public User getUserById(int id) {
		Optional<User> o=ur.findById(id);
		if (id > 300) {
			throw new UserSerException("invalid id", HttpStatus.BAD_REQUEST);
		}
		if(o.isEmpty())
		{
			throw new UserSerException("no content", HttpStatus.NO_CONTENT);
		}
		return o.get();
	}

	public List<User> getUserByMobileNo(String mobileNo) {
		if (mobileNo.length() < 10 ||mobileNo.length() > 10) {
			throw new UserSerException("invalid mobile no", HttpStatus.BAD_REQUEST);
		}
		return ur.findByMobileNo(mobileNo);
	}

	public List<User> getUserByName(String name) {
		if (name.length() > 10) {
			throw new UserSerException("there is no user of such name ", HttpStatus.BAD_REQUEST);
		}
		return ur.findByName(name);
	}

	public List<User> getAllUsers() {
		return ur.findAll();
	}

	public void deleteUserById(int id) {
		ur.deleteById(id);
	}

}
