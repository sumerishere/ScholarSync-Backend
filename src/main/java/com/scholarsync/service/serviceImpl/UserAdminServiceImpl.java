package com.scholarsync.service.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.scholarsync.bcryptPasswordEncoder.BcryptEncoderConfig;
import com.scholarsync.model.UserAdmin;
import com.scholarsync.repository.UserAdminRepository;
import com.scholarsync.service.UserAdminService;

@Service
public class UserAdminServiceImpl implements UserAdminService{
	
	@Autowired
	private UserAdminRepository userAdminRepository;

	@Autowired
	private BcryptEncoderConfig passwordEncoder;

	

	//----------------------------  UserAdmin creating (POST) Api ----------------------------------//
	
	public ResponseEntity<?> createUserAdmin(UserAdmin userAdmin) {
		
		try {
			 // Checking if user already exists.
	        if (userAdminRepository.findByEmail(userAdmin.getEmail()).isPresent()) {
	            return new ResponseEntity<>("user is already present!!!", HttpStatus.BAD_REQUEST);
	        }
	        
	        String encodedPassword = passwordEncoder.encode(userAdmin.getPassword());
	        userAdmin.setPassword(encodedPassword);
				
			return new ResponseEntity<>(userAdminRepository.save(userAdmin),HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>("internal server error!!"+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}
	//------------------------------------------------------------------------------------------------//

	

}
