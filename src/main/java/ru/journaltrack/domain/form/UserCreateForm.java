package ru.journaltrack.domain.form;


import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import ru.journaltrack.domain.Role;

@Data
public class UserCreateForm {
    @NotEmpty(message = "Поле логин не может быть пустое")
    private String username;
    @NotEmpty(message = "Поле пароль не может быть пустое")
    private String password;
    @Email
    @NotEmpty(message = "Поле e-mail не может быть пустое")
    private String mail;
   // @NotEmpty
    private Role authorities;
}
