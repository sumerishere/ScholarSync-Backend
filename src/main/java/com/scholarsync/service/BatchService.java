package com.scholarsync.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.scholarsync.model.Batch;

public interface BatchService {
	
	ResponseEntity<Batch> createBatch(Batch batch);
    
    Batch updateBatch(Long batchId, Batch batch);
    
    List<Batch> getAllBatches();
    
    Batch getBatchById(Long batchId);
    
    void deleteBatch(Long batchId);
}
