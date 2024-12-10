package com.scholarsync.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scholarsync.model.Batch;

@RestController
@RequestMapping("/api/batch")
public class BatchController {

    public ResponseEntity<Batch> createBatch(){
        return null;
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
