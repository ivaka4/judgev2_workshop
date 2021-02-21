package com.example.judgev2.workshop.service.impl;

import com.example.judgev2.workshop.model.entity.Exercise;
import com.example.judgev2.workshop.model.entity.Homework;
import com.example.judgev2.workshop.model.entity.User;
import com.example.judgev2.workshop.model.view.HomeworkAddModel;
import com.example.judgev2.workshop.repository.HomeworkRepository;
import com.example.judgev2.workshop.service.ExerciseService;
import com.example.judgev2.workshop.service.HomeworkService;
import com.example.judgev2.workshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeworkRepository homeworkRepository;
    private final UserService userService;
    private final ExerciseService exerciseService;
    private final ModelMapper modelMapper;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, UserService userService, ExerciseService exerciseService, ModelMapper modelMapper) {
        this.homeworkRepository = homeworkRepository;
        this.userService = userService;
        this.exerciseService = exerciseService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addHomework(HomeworkAddModel homeworkAddModel) {
        User user = this.userService.findByGitAddress(homeworkAddModel.getGitAddress());
        Exercise exercise = this.exerciseService.findByName(homeworkAddModel.getExercise());
        Homework homework = new Homework();
        homework.setAddedOn(LocalDateTime.now());
        homework.setAuthor(user);
        homework.setExercise(exercise);
        homework.setGitAddress(homeworkAddModel.getGitAddress());
        this.homeworkRepository.saveAndFlush(homework);
    }
}
