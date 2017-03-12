package ru.journaltrack.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.journaltrack.domain.UserCreateForm;
import ru.journaltrack.Services.UserService;

@Component
public class UserCreateFormValidator implements Validator{
   @Autowired
   private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form= (UserCreateForm) target;
        validateUsername(errors,form);
        validatePasswords(errors,form);
    }
    private void validatePasswords(Errors errors, UserCreateForm form) {
/*        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }*/
    }

    private void validateUsername(Errors errors, UserCreateForm form) {
        if (userService.getUserByUsername(form.getUsername()).isPresent()) {
            errors.reject("username.exists", "User with this name already exists");
        }
    }
}
