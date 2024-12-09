package com.scholarsync.service;

import java.util.List;

import com.scholarsync.model.Trainer;

public interface TrainerService {
    Trainer createTrainer(Trainer trainer);
    Trainer updateTrainer(Long trainerId, Trainer trainer);
    List<Trainer> getAllTrainers();
    Trainer getTrainerById(Long trainerId);
    void deleteTrainer(Long trainerId);
}
