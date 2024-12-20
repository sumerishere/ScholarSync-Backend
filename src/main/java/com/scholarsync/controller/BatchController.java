package com.scholarsync.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scholarsync.model.Batch;
import com.scholarsync.request.BatchRequest;
import com.scholarsync.service.BatchService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/batch")
public class BatchController {
	
	
    private final BatchService batchService;

    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    @PostMapping("/create-batch")
    public ResponseEntity<Batch> createBatch(@RequestBody BatchRequest batchRequest) {
        Batch createdBatch = batchService.createBatch(batchRequest);
        return new ResponseEntity<>(createdBatch, HttpStatus.CREATED);
    }

    @PutMapping("/{batchId}")
    public ResponseEntity<Batch> updateBatch(@PathVariable("batchId") String batchId, @RequestBody BatchRequest batchRequest) {
        Batch updatedBatch = batchService.updateBatch(batchId, batchRequest);
        return ResponseEntity.ok(updatedBatch);
    }

    @GetMapping("/get-all-batch")
    public ResponseEntity<List<Batch>> getAllBatches() {
        List<Batch> batches = batchService.getAllBatches();
        return ResponseEntity.ok(batches);
    }

    @GetMapping("/get-batch/{batchId}")
    public ResponseEntity<Batch> getBatchById(@PathVariable("batchId") String batchId) {
        Batch batch = batchService.getBatchById(batchId);
        return ResponseEntity.ok(batch);
    }

    @DeleteMapping("/{batchId}")
    public ResponseEntity<Void> deleteBatch(@PathVariable("batchId") String batchId) {
        batchService.deleteBatch(batchId);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/search-batch")
    public ResponseEntity<List<Batch>> searchBatches(@RequestParam("batchName") String batchName) {
        List<Batch> batches = batchService.searchBatches(batchName);
        return ResponseEntity.ok(batches);
    } 
}