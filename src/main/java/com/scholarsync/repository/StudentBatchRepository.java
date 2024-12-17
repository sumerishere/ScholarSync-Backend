package com.scholarsync.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scholarsync.model.Batch;
import com.scholarsync.model.StudentBatch;
import com.scholarsync.model.StudentsModel;

@Repository
public interface StudentBatchRepository extends JpaRepository<StudentBatch,Long>{
    Optional<StudentBatch> findByStudentsModel(StudentsModel studentsModel);
    boolean existsByStudentsModelAndBatch(StudentsModel studentsModel,Batch batch);
    
}
