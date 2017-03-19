package ru.journaltrack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.journaltrack.Services.OrderService;
import ru.journaltrack.Services.UserService;
import ru.journaltrack.domain.form.UserCreateForm;
import ru.journaltrack.domain.form.UserSubscribeForm;

import javax.validation.Valid;

@Controller
public class UserController {
    private UserService userService;
    private OrderService orderService;

    @Autowired
    public UserController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
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

    @GetMapping(value = "/subscribe")
    public String subscribe(Model model) {
        model.addAttribute("form", new UserSubscribeForm());
        model.addAttribute("orders", orderService.findAll());
        return "subscribe";
    }

    @PostMapping(value = "/subscribe")
    public String subscribe(@ModelAttribute("form") UserSubscribeForm form) {
        userService.subscribe(form);
        return "redirect:/subscribe";
    }
}
