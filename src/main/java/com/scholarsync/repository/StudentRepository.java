package com.scholarsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scholarsync.model.StudentsModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentsModel, Long>{
	
}
