package com.example.judgev2.workshop.model.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginModel {
    @Length(min = 2, message = "Username length must me minimum two characters")
    private String username;
    @Length(min = 3, message = "Username length must me minimum three characters")
    private String password;
}
