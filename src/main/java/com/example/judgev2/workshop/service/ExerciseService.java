package com.example.judgev2.workshop.service;

import com.example.judgev2.workshop.model.entity.Exercise;
import com.example.judgev2.workshop.model.view.ExercisesAddModel;

import java.util.List;

public interface ExerciseService {

    void addExercise(ExercisesAddModel exercisesAddModel);

    List<String> getAllExercises();

    Exercise findByName(String name);
}
