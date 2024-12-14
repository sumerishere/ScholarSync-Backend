package com.scholarsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scholarsync.model.Batch;
@Repository
public interface BatchRepository extends JpaRepository<Batch,String>{
    
	//pull dev first
}
