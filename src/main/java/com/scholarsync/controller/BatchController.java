package com.scholarsync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scholarsync.model.Batch;
import com.scholarsync.service.BatchService;

@RestController
@RequestMapping("/api/batch")
public class BatchController {
	
	@Autowired
	BatchService batchService;

	
	@PostMapping("/create-batch")
    public ResponseEntity<Batch> createBatch(@RequestBody Batch batch){
    	
    	if(batch == null) {
    		throw new RuntimeException("batch data required!!");
    	}
    	return batchService.createBatch(batch);
    }

    public ResponseEntity<Batch> updateBatch(){
        return null;
    }

    public ResponseEntity<List<Batch>> getAllBatch(){
        return null;
    }

    public ResponseEntity<Batch> getBatchById(){
        return null;
    }

    public ResponseEntity<Void> deleteBatch(){
        return null;
    }
}
