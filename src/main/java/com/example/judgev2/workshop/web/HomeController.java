package com.example.judgev2.workshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {


    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
}
