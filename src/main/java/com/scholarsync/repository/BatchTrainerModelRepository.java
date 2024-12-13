package com.scholarsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scholarsync.model.BatchTrainerModel;

public interface BatchTrainerModelRepository extends JpaRepository<BatchTrainerModel,Long>{
    
}
