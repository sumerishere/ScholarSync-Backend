package com.scholarsync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scholarsync.model.UserAdmin;
import com.scholarsync.service.UserAdminService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin")
public class UserAdminController {
	
	@Autowired
	UserAdminService userAdminService;
	
	@PostMapping("/create-user")
	public ResponseEntity<?> createUserAdmin(@RequestBody UserAdmin userAdmin){
		return userAdminService.createUserAdmin(userAdmin);
	}
	
	
}
