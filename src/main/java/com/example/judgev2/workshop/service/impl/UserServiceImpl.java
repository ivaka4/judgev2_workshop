package com.example.judgev2.workshop.service.impl;

import com.example.judgev2.workshop.model.entity.RoleNameEnum;
import com.example.judgev2.workshop.model.entity.User;
import com.example.judgev2.workshop.model.service.UserServiceModel;
import com.example.judgev2.workshop.repository.UserRepository;
import com.example.judgev2.workshop.security.CurrentUser;
import com.example.judgev2.workshop.service.RoleService;
import com.example.judgev2.workshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        if (userRepository.count() == 0) {
            user.setRole(roleService.findRole(RoleNameEnum.ADMIN));
        } else {
            user.setRole(roleService.findRole(RoleNameEnum.USER));
        }

        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser.setId(userServiceModel.getId());
        currentUser.setUsername(userServiceModel.getUsername());
        currentUser.setRole(userServiceModel.getRole().getName());
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
        currentUser.setRole(null);
    }
}
