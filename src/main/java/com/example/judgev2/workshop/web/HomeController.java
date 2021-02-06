package com.example.judgev2.workshop.web;

import com.example.judgev2.workshop.security.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {
    private final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

//    @GetMapping("/")
//    public ModelAndView index(){
//        return new ModelAndView("index");
//    }

    @GetMapping("/")
    public ModelAndView home(){
       if (currentUser.isAnonymous()){
           return new ModelAndView("index");
       }
       return new ModelAndView("home");
    }
}
