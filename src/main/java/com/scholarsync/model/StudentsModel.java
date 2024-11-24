package com.scholarsync.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private Long   studentId;
	private String studentName;
	private String studentAddress;
	private String studentEmail;
	private String studenttMobileNumber;
	private String studentBatch;

}
