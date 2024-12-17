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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    private Long studentId;

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @Column(name = "firstname")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    @Column(name = "lastname")
    private String lastName;

    @NotBlank(message = "Address is required")
    @Size(max = 200, message = "Address must be less than 200 characters")
    @Column(name = "student_address")
    private String studentAddress;

    @NotBlank(message = "Email is required")
    @Pattern(
        regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", 
        message = "Invalid email format"
    )
    @Column(name = "student_email")
    private String studentEmail;

    @NotBlank(message = "Mobile number is required")
    @Pattern(
        regexp = "^\\+?1?\\s*\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$", 
        message = "Invalid mobile number format"
    )
    @Column(name = "student_mobileNumber")
    private String studentMobileNumber;

    @NotBlank(message = "Stream is required")
    @Size(max = 50, message = "Stream must be less than 50 characters")
    @Column(name = "stream")
    private String stream;

}
