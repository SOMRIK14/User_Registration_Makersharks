package com.somrik.Makersharks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;

import com.somrik.Makersharks.dto.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

	boolean existsByEmail(String email);

	boolean existsByMob(long mob);

	boolean existsByUsername(String username);

	User findByUsername(String username);

	
}
