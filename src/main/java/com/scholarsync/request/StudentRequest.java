package com.scholarsync.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
	private String firstName;
	private String lastName;
	private String studentAddress;
	private String studentEmail;
	private String studenttMobileNumber;
	private String stream;
    private String batchId;
}
