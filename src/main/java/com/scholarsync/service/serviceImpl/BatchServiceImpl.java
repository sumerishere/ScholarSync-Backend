package com.scholarsync.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.scholarsync.model.Batch;
import com.scholarsync.repository.BatchRepository;
import com.scholarsync.service.BatchService;

@Service
public class BatchServiceImpl implements BatchService {
	
	@Autowired
	BatchRepository batchRepository;

    @Override
    public ResponseEntity<Batch> createBatch(Batch batch) {
       return new ResponseEntity<>(batchRepository.save(batch), HttpStatus.CREATED);
    }

    @Override
    public Batch updateBatch(Long batchId, Batch batch) {
       return null;
    }

    @Override
    public List<Batch> getAllBatches() {
       return null;
    }

    @Override
    public Batch getBatchById(Long batchId) {
       return null;
    }

    @Override
    public void deleteBatch(Long batchId) {
       
    }
    
    
}