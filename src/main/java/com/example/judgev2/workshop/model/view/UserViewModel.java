package com.example.judgev2.workshop.model.view;

import com.example.judgev2.workshop.model.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
public class UserViewModel {

    private String username;
    private Role role;
}
