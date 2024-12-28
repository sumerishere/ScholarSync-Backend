package com.scholarsync.request;

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
	private String studentMobileNumber;
	private String stream;
    private String batchId;
    
    private String courseType;

    private long feesPaid;
    private long discount; 
    private long totalFees;
  
}
