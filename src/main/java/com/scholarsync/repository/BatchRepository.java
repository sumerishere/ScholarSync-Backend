package com.scholarsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scholarsync.model.Batch;

public interface BatchRepository extends JpaRepository<Batch, Long> {

}
