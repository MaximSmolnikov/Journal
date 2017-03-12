package ru.journaltrack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.journaltrack.domain.User;
import ru.journaltrack.domain.UserCreateForm;
import ru.journaltrack.Services.UserService;
import ru.journaltrack.validator.UserCreateFormValidator;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    private UserCreateFormValidator userCreateFormValidator;

    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(userCreateFormValidator);
    }

    @GetMapping(value = "/user/create")
    public ModelAndView getUserCreatePage() {
        return new ModelAndView("user_create", "form", new UserCreateForm());
    }

    @PostMapping(value = "/user/create")
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
        System.out.println(form);
        if (bindingResult.hasErrors()) {
            return "user_create";
        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("email.exists", "Email already exists");
            return "user_create";
        }
        return "redirect:/";
    }
    @GetMapping(value = "/users")
    public String users(Model model,Principal principal){
/*        List<User> users= userService.findByUsernameNotLike(principal.getName());
        model.addAttribute("users",users);*/

        return "users";
    }
}
