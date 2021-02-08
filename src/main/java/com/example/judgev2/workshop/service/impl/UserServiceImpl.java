package com.example.judgev2.workshop.service.impl;

import com.example.judgev2.workshop.model.entity.RoleNameEnum;
import com.example.judgev2.workshop.model.entity.User;
import com.example.judgev2.workshop.model.service.UserServiceModel;
import com.example.judgev2.workshop.model.view.UserViewModel;
import com.example.judgev2.workshop.repository.UserRepository;
import com.example.judgev2.workshop.security.CurrentUser;
import com.example.judgev2.workshop.service.RoleService;
import com.example.judgev2.workshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    @Override
    public List<UserViewModel> getAllUsers() {
        return this.modelMapper.map(this.userRepository.findAll(), new TypeToken<List<UserViewModel>>() {
        }.getType());
    }

    @Override
    public void addRole(String username, RoleNameEnum role) {
        User user = this.userRepository.findByUsername(username);
        if (user.getRole().getName() != role) {
            user.setRole(this.roleService.findRole(role));
            this.userRepository.saveAndFlush(user);
        }
    }
}
