package com.scholarsync.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scholarsync.model.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, String>{
    
	@Query("SELECT batch FROM Batch batch WHERE batch.batchName LIKE %:batchName%")
	List<Batch> searchByBatchName(@Param("batchName") String batchName);
	
	
//	@Query("SELECT lead FROM LeadFollowUp lead WHERE lead.name LIKE %:name%")
//	List<LeadFollowUp> searchByLeadName(@Param("name") String name);
}
