package com.example.judgev2.workshop.web;

import com.example.judgev2.workshop.model.entity.RoleNameEnum;
import com.example.judgev2.workshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/roles")
public class RoleController extends BaseController{
    private final UserService userService;

    public RoleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public ModelAndView addRole(){
        ModelAndView modelAndView = new ModelAndView("role-add");
        modelAndView.addObject("users", userService.getAllUsers());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addRoleConfirm(@RequestParam String username, @RequestParam String role){
        userService.addRole(username, RoleNameEnum.valueOf(role.toUpperCase()));
        return super.redirect("/");
    }
}
