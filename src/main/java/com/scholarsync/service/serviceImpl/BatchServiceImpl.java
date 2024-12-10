package com.scholarsync.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scholarsync.model.Batch;
import com.scholarsync.service.BatchService;

@Service
public class BatchServiceImpl implements BatchService {

    @Override
    public Batch createBatch(Batch batch) {
       return null;
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