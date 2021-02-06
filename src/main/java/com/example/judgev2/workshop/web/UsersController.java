package com.example.judgev2.workshop.web;

import com.example.judgev2.workshop.model.service.UserServiceModel;
import com.example.judgev2.workshop.model.view.UserLoginModel;
import com.example.judgev2.workshop.model.view.UserRegisterModel;
import com.example.judgev2.workshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController extends BaseController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UsersController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public ModelAndView login(Model model) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (!model.containsAttribute("userLoginModel")){
            model.addAttribute("userLoginModel", new UserLoginModel());
            model.addAttribute("notFound", false);
        }
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginConfirm(@Valid @ModelAttribute UserLoginModel userLoginModel,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes,
                                     HttpSession httpSession) {
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginModel", userLoginModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginModel", bindingResult);
            return super.redirect("login");
        }

        UserServiceModel user = userService
                .findUserByUsernameAndPassword(userLoginModel.getUsername(), userLoginModel.getPassword());

        if (user == null){
            redirectAttributes.addFlashAttribute("userLoginModel", userLoginModel);
            redirectAttributes.addFlashAttribute("notFound", true);

            return super.redirect("login");
        }
        userService.login(user);
        return super.redirect("/");
    }

    @GetMapping("/register")
    public ModelAndView register(Model model) {
        ModelAndView modelAndView = new ModelAndView("register");
        if (!model.containsAttribute("userRegisterModel")) {
            modelAndView.addObject("userRegisterModel", new UserRegisterModel());
        }
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(@Valid @ModelAttribute UserRegisterModel userRegisterModel,
                                        BindingResult bindingResult,
                                        RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors() || !userRegisterModel.getPassword().equals(userRegisterModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterModel", userRegisterModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterModel", bindingResult);
            return super.redirect("register");
        }
        UserServiceModel userServiceModel = modelMapper.map(userRegisterModel, UserServiceModel.class);
        userService.registerUser(userServiceModel);
        return super.redirect("login");
    }

    @GetMapping("/logout")
    public ModelAndView logout(){
        userService.logout();
        return super.redirect("/");
    }
}
