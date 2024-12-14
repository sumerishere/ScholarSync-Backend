package com.scholarsync.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class Batch {
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "batch_id")
    private Long batchId;
    
    @Column(name = "batch_code")
    private String batchCode;
    
    @Column(name = "batchName")
    private String batchName;
    
    @Column(name = "courseName")
    private String courseName;
    
    @Column(name = "start_date")
    private Date startDate;

    private List<String> tranerName;
    
    // @Column(name = "end_date")
    // private Date endDate;
    
}