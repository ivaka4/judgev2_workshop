package com.example.judgev2.workshop.model.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterModel {
    @Length(min = 2, message = "Username length must me minimum two characters")
    @NotNull
    private String username;
    @Length(min = 3, message = "Username length must me minimum three characters")
    @NotNull
    private String password;
    private String confirmPassword;
    @Email(message = "Enter valid email address")
    @NotNull
    private String email;
    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+", message = "Enter valid git address")
    @NotNull
    private String git;

}
