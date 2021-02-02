package com.example.judgev2.workshop.service;

import com.example.judgev2.workshop.model.service.UserServiceModel;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);
}
