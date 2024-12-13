package com.scholarsync.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scholarsync.exception.ResourceNotFoundException;
import com.scholarsync.model.Trainer;
import com.scholarsync.repository.TrainerRepository;
import com.scholarsync.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    TrainerRepository trainerRepository;

    @Override
    public Trainer createTrainer(Trainer trainer) {
        List<Trainer> trainers = trainerRepository.findAll();
        if (trainers.stream().anyMatch(t -> t.getEmailAddress().equals(trainer.getEmailAddress()))) {
            throw new IllegalArgumentException("Trainer with the same email address already exists.");
        }
        return trainerRepository.save(trainer);
    }

    @Override
    public Trainer updateTrainer(Long trainerId, Trainer trainer) {
        Trainer existingTrainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new ResourceNotFoundException("Trainer not found with id: " + trainerId));
        existingTrainer.setFirstName(trainer.getFirstName());
        existingTrainer.setLastName(trainer.getLastName());
        existingTrainer.setAddress(trainer.getAddress());
        existingTrainer.setEmailAddress(trainer.getEmailAddress());
        existingTrainer.setPhoneNumber(trainer.getPhoneNumber());
        existingTrainer.setQualification(trainer.getQualification());
        existingTrainer.setRole(trainer.getRole());
        return trainerRepository.save(existingTrainer);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainerById(Long trainerId) {
        return trainerRepository.findById(trainerId)
                .orElseThrow(() -> new ResourceNotFoundException("Trainer not found with id: " + trainerId));
    }

    @Override
    public void deleteTrainer(Long trainerId) {
        Trainer existingTrainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new ResourceNotFoundException("Trainer not found with id: " + trainerId));
        trainerRepository.delete(existingTrainer);
    }
}