package com.example.judgev2.workshop.model.service;

import com.example.judgev2.workshop.model.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserServiceModel {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String git;
    private Role role;
}
