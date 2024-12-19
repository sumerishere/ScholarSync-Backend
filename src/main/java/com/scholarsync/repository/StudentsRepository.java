package com.scholarsync.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scholarsync.model.StudentsModel;

@Repository
public interface StudentsRepository  extends JpaRepository<StudentsModel, Long>{
    Optional<StudentsModel> findByFirstNameOrLastName(String firstName, String lastName);
    Optional<StudentsModel> findByStudentEmailOrStudentMobileNumber(String email, String mobileNumber);
    Optional<StudentsModel>  findByStudentEmail(String studentEmail);
} 
