package com.scholarsync.model;

import java.time.DateTimeException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentsModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  studentId;
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "student_address")
	private String studentAddress;
	
	@Column(name = "student_email")
	private String studentEmail;
	
	@Column(name = "student_mobileNumber")
	private String studenttMobileNumber;
	
	@Column(name = "stream")
	private String stream;
	
}
