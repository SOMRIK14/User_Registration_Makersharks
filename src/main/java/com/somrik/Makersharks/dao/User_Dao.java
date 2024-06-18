package com.somrik.Makersharks.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.somrik.Makersharks.dto.User;
import com.somrik.Makersharks.repository.UserRepository;

@Repository
public class User_Dao {

	@Autowired
	UserRepository repository;

	public User saveDetails(User user) {
		User user2 = repository.save(user);
		return user2;
	}

	public boolean checkEmail(String email) {
		if (repository.existsByEmail(email)) {
			return true;
		} else {
			return false;

		}
	}

	public boolean checkMob(long mob) {
		if (repository.existsByMob(mob)) {
			return true;
		} else {
			return false;

		}

	}

	public boolean checkUsername(String username) {
		if (repository.existsByUsername(username)) {
			return true;
		} else {
			return false;

		}
	}

	public User fetchByUsername(String username) {
		// TODO Auto-generated method stub
		return repository.findByUsername(username);
	}

}
