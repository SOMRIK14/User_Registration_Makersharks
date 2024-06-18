package com.somrik.Makersharks.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.somrik.Makersharks.dto.User;
import com.somrik.Makersharks.service.User_Service;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/user")
public class User_Controller {

	@Autowired
	User user;

    @Autowired
    User_Service service;
	
    @PostMapping("/register")
    public ResponseEntity<ModelMap> signUp(@Valid @RequestBody User user) {

    
    	 return service.signUp(user);
    }
    
    
    @GetMapping("/fetch/{username}")
    public ResponseEntity<ModelMap> fetchByUsername(@PathVariable String username)
    {
    	return service.fetchByUsername(username);
    }
}
