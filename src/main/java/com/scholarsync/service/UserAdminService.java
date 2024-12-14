package com.scholarsync.service;

import org.springframework.http.ResponseEntity;

import com.scholarsync.model.UserAdmin;

public interface UserAdminService {
	
	public ResponseEntity<?> createUserAdmin(UserAdmin userAdmin);

}
