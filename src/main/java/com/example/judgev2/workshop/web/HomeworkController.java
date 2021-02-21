package com.example.judgev2.workshop.web;

import com.example.judgev2.workshop.model.view.HomeworkAddModel;
import com.example.judgev2.workshop.service.ExerciseService;
import com.example.judgev2.workshop.service.HomeworkService;
import com.example.judgev2.workshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/homework")
public class HomeworkController extends BaseController {
    private final HomeworkService homeworkService;
    private final ExerciseService exerciseService;
    private final UserService userService;

    public HomeworkController(HomeworkService homeworkService, ExerciseService exerciseService, UserService userService) {
        this.homeworkService = homeworkService;
        this.exerciseService = exerciseService;
        this.userService = userService;
    }


    @GetMapping("/add")
    public ModelAndView addHomework(Model model){
        ModelAndView modelAndView = new ModelAndView("homework-add");
        modelAndView.addObject("exercises", exerciseService.getAllExercises());
        if (!model.containsAttribute("homeworkAddModel")) {
            modelAndView.addObject("homeworkAddModel", new HomeworkAddModel());
        }
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addHomeworkConfirm(@Valid @ModelAttribute HomeworkAddModel homeworkAddModel,
                                           BindingResult bindingResult,
                                           RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("homeworkAddModel", homeworkAddModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.homeworkAddModel",
                    bindingResult);
            return super.redirect("/homework/add");
        }

        this.homeworkService.addHomework(homeworkAddModel);
        return super.redirect("/");
    }

    @GetMapping("/check-homework")
    public ModelAndView checkHomework(){
        return new ModelAndView("homework-check");
    }
}
