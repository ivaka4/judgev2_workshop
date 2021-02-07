package com.example.judgev2.workshop.service.impl;

import com.example.judgev2.workshop.model.entity.Exercise;
import com.example.judgev2.workshop.model.view.ExercisesAddModel;
import com.example.judgev2.workshop.repository.ExerciseRepository;
import com.example.judgev2.workshop.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addExercise(ExercisesAddModel exercisesAddModel) {
        Exercise exercise = this.modelMapper.map(exercisesAddModel, Exercise.class);
        this.exerciseRepository.saveAndFlush(exercise);
    }
}
