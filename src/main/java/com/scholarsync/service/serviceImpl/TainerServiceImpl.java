package com.scholarsync.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scholarsync.model.Trainer;
import com.scholarsync.repository.TrainerRepository;
import com.scholarsync.service.TrainerService;

@Service
public class TainerServiceImpl implements TrainerService  {

    @Autowired
    TrainerRepository trainerRepository;

    @Override
    public Trainer createTrainer(Trainer trainer) {
        List<Trainer> trainers = trainerRepository.findAll();
        if(trainers.contains(trainers)){
            throw new RuntimeErrorException(null);
        }
       return trainerRepository.save(trainer);
    }

    @Override
    public Trainer updateTrainer(Long trainerId, Trainer trainer) {
        Optional<Trainer> trianer = trainerRepository.findById(trainerId);
        if(trianer.isEmpty()){

        }
        Trainer existingTrainer = trianer.orElseThrow();
        return existingTrainer;
    }

    @Override
    public List<Trainer> getAllTrainers() {
        List<Trainer> trainers = trainerRepository.findAll();
        if(trainers==null){

        }
        return trainers;
    }

    @Override
    public Trainer getTrainerById(Long trainerId) {
        Optional<Trainer> trainer = trainerRepository.findById(trainerId);
        if(trainer.isEmpty()){

        }
        return trainer.orElseThrow();
    }

    @Override
    public void deleteTrainer(Long trainerId) {
        trainerRepository.deleteById(trainerId);
    }
    
}
