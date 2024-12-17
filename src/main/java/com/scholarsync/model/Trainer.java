package com.scholarsync.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainerId")
    private Long id;
    
    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @Column(name = "firstName")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    @Column(name = "lastName")
    private String lastName;
    
    @NotBlank(message = "Address is required")
    @Size(max = 200, message = "Address must be less than 200 characters")
    @Column(name = "address")
    private String address;
    
    @NotBlank(message = "Email address is required")
    @Pattern(
        regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", 
        message = "Invalid email format"
    )
    @Column(name = "emailaddress")
    private String emailAddress;
    
    @NotBlank(message = "Phone number is required")
    @Pattern(
        regexp = "^\\+?1?\\s*\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$", 
        message = "Invalid phone number format"
    )
    @Column(name = "phoneNumber")
    private String phoneNumber;
    
    @NotBlank(message = "Qualification is required")
    @Size(max = 100, message = "Qualification must be less than 100 characters")
    @Column(name = "qualification")
    private String qualification;
    
    @NotBlank(message = "Role is required")
    @Size(max = 50, message = "Role must be less than 50 characters")
    @Column(name = "role")
    private String role;

}