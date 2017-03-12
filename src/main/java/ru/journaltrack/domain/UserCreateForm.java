package ru.journaltrack.domain;


import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class UserCreateForm {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @Email
    @NotEmpty
    private String mail;
   // @NotEmpty
    private Role authorities;
}
