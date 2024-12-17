package com.scholarsync.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.scholarsync.exception.ResourceNotFoundException;
import com.scholarsync.model.Batch;
import com.scholarsync.model.BatchTrainerModel;
import com.scholarsync.model.Trainer;
import com.scholarsync.repository.BatchRepository;
import com.scholarsync.repository.BatchTrainerModelRepository;
import com.scholarsync.repository.TrainerRepository;
import com.scholarsync.request.BatchRequest;
import com.scholarsync.service.BatchService;

@Service
public class BatchServiceImpl implements BatchService {
	
    private final BatchRepository batchRepository;
    private final TrainerRepository trainerRepository;
    private final BatchTrainerModelRepository batchTrainerModelRepository;

    public BatchServiceImpl(BatchRepository batchRepository,TrainerRepository trainerRepository,BatchTrainerModelRepository batchTrainerModelRepository) {
        this.batchRepository = batchRepository;
        this.trainerRepository=trainerRepository;
        this.batchTrainerModelRepository=batchTrainerModelRepository;
    }

    @Override
    public Batch createBatch(BatchRequest batchRequest) {
    
        String batchId ="#" + UUID.randomUUID().toString().substring(0, 4);
        
        Batch batch = new Batch(
            batchId, 
            batchRequest.getBatchName(), 
            batchRequest.getCourseName(), 
            batchRequest.getStartDate()
        );
        

        Batch savedBatch = batchRepository.save(batch);
        
       
        for (Long trainerId : batchRequest.getTrianerId()) {
            Optional<Trainer> trainerOptional = trainerRepository.findById(trainerId);
            
            if (trainerOptional.isEmpty()) {
                throw new ResourceNotFoundException("Trainer not found with id: " + trainerId);
            }
            
          
            boolean associationExists = batchTrainerModelRepository.existsByBatcheAndTrainers(savedBatch, trainerOptional.get());
            
            if (!associationExists) {
                BatchTrainerModel batchTrainerModel = new BatchTrainerModel();
                batchTrainerModel.setBatche(savedBatch);
                batchTrainerModel.setTrainers(trainerOptional.get());
                batchTrainerModelRepository.save(batchTrainerModel);
            }
        }
        
        return savedBatch;
    }

    @Override
    public Batch updateBatch(String batchId, BatchRequest batchRequest) {
        Batch batch = batchRepository.findById(batchId).orElseThrow(() -> new ResourceNotFoundException("Batch not found"));
        batch.setBatchName(batchRequest.getBatchName());
        batch.setCourseName(batchRequest.getCourseName());
        batch.setStartDate(batchRequest.getStartDate());
        return batchRepository.save(batch);
    }

    @Override
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    @Override
    public Batch getBatchById(String batchId) {
        return batchRepository.findById(batchId).orElseThrow(() -> new ResourceNotFoundException("Batch not found"));
    }

    @Override
    public void deleteBatch(String batchId) {
        Batch batch = batchRepository.findById(batchId).orElseThrow(() -> new ResourceNotFoundException("Batch not found"));
        batchRepository.delete(batch);
    }

	@Override
	public List<Batch> searchBatches(String batchName) {
		return batchRepository.searchByBatchName(batchName);
	}

    
}