package com.example.judgev2.workshop.web;

import com.example.judgev2.workshop.model.view.ExercisesAddModel;
import com.example.judgev2.workshop.model.view.UserRegisterModel;
import com.example.judgev2.workshop.service.ExerciseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/exercises")
public class ExerciseController extends BaseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/add")
    public ModelAndView addExercise(Model model){
        ModelAndView modelAndView = new ModelAndView("exercise-add");
        if (!model.containsAttribute("exerciseAddModel")) {
            modelAndView.addObject("exerciseAddModel", new ExercisesAddModel());
        }
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addExerciseConfirm(@Valid @ModelAttribute ExercisesAddModel exercisesAddModel,
                                           BindingResult bindingResult,
                                           RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("exerciseAddModel", exercisesAddModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.exerciseAddModel", bindingResult);
            return super.redirect("/exercises/add");
        }
        this.exerciseService.addExercise(exercisesAddModel);
        return super.redirect("/");
    }
}
