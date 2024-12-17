package com.scholarsync.service;

import java.util.List;


import com.scholarsync.model.Batch;
import com.scholarsync.request.BatchRequest;

public interface BatchService {

    Batch createBatch(BatchRequest batch);
    
    Batch updateBatch(String batchId, BatchRequest batch);
    
    List<Batch> getAllBatches();
    
    List<Batch> searchBatches(String batchName);
    
    Batch getBatchById(String batchId);
    
    void deleteBatch(String batchId);
}
