package com.scholarsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scholarsync.model.Batch;
import com.scholarsync.model.BatchTrainerModel;
import com.scholarsync.model.Trainer;

public interface BatchTrainerModelRepository extends JpaRepository<BatchTrainerModel,Long>{
     boolean existsByBatcheAndTrainers(Batch batch, Trainer trainer);
}
