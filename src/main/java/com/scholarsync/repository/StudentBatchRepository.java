package com.scholarsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scholarsync.model.StudentBatch;

@Repository
public interface StudentBatchRepository extends JpaRepository<StudentBatch,Long>{
    
}
