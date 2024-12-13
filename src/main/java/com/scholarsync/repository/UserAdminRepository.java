package com.scholarsync.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scholarsync.model.UserAdmin;

@Repository
public interface UserAdminRepository extends JpaRepository<UserAdmin, Long>{
	
	Optional<UserAdmin>  findByEmail(String email);
	
	
}
