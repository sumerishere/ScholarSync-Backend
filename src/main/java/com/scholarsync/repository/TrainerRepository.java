package com.scholarsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scholarsync.model.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Long> {
    
}
