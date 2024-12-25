package com.scholarsync.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scholarsync.model.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, String>{
    
	@Query("SELECT batch FROM Batch batch WHERE batch.batchName LIKE %:batchName%")
	List<Batch> searchByBatchName(@Param("batchName") String batchName);
	
	List<Batch> findAll(Sort sort);

	
}
