package com.example.judgev2.workshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exercises")
public class ExerciseController {

    @GetMapping("/add")
    public ModelAndView addExercise(){
        return new ModelAndView("exercise-add");
    }
}
