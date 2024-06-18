package com.somrik.Makersharks.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.somrik.Makersharks.dao.User_Dao;
import com.somrik.Makersharks.dto.User;
import com.somrik.Makersharks.helper.AES;

@Service
public class User_Service {

	@Autowired
	User_Dao dao;

	public ResponseEntity<ModelMap> signUp(User user) {
		ModelMap response = new ModelMap();

			if (dao.checkEmail(user.getEmail()) && dao.checkMob(user.getMob()) && dao.checkUsername(user.getUsername()))
			{

				response.put("msg", "* Username,Email,Mobile already exist");
				return new ResponseEntity<>(response, HttpStatus.CONFLICT);
			} 
			else if (dao.checkUsername(user.getUsername())) {
				response.put("msg", "* Username already exists");
				return new ResponseEntity<>(response, HttpStatus.CONFLICT);
			} 
			else if (dao.checkEmail(user.getEmail())) {
				response.put("msg", "* Email already exists");
				return new ResponseEntity<>(response, HttpStatus.CONFLICT);

			} 
			else if (dao.checkMob(user.getMob())) {

				response.put("msg", "* Mobile already exists");
				return new ResponseEntity<>(response, HttpStatus.CONFLICT);
			}

			else {
				user.setPassword(AES.encrypt(user.getPassword(), "173"));
				response.put("user", dao.saveDetails(user));
				response.put("msg", "Data inseted successfully");
				return new ResponseEntity<>(response, HttpStatus.CREATED);
			}


	}

	public ResponseEntity<ModelMap> fetchByUsername(String username) {
		ModelMap resp = new ModelMap();
		if (dao.fetchByUsername(username) == null) {
			resp.put("message", "No data found for the Username");
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}
		else {
			resp.put("user", dao.fetchByUsername(username));
			resp.put("message", "Data Found");
			return new ResponseEntity<>(resp, HttpStatus.FOUND);
		}

	}

}
