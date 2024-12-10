package com.scholarsync.service;

import java.util.List;

import com.scholarsync.model.Batch;

public interface BatchService {
    Batch createBatch(Batch batch);
    Batch updateBatch(Long batchId, Batch batch);
    List<Batch> getAllBatches();
    Batch getBatchById(Long batchId);
    void deleteBatch(Long batchId);
}
