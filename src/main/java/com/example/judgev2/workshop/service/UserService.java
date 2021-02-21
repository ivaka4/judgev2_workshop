package com.example.judgev2.workshop.service;

import com.example.judgev2.workshop.model.entity.RoleNameEnum;
import com.example.judgev2.workshop.model.entity.User;
import com.example.judgev2.workshop.model.service.UserServiceModel;
import com.example.judgev2.workshop.model.view.UserViewModel;

import java.util.List;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel userServiceModel);

    void logout();

    List<UserViewModel> getAllUsers();

    void addRole(String username, RoleNameEnum role);

    User findByGitAddress(String address);


    boolean gitExist(String gitAddress);

}

