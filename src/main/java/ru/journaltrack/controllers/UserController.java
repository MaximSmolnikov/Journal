package ru.journaltrack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.journaltrack.domain.form.UserCreateForm;
import ru.journaltrack.domain.form.UserSubscribeForm;
import ru.journaltrack.services.OrderService;
import ru.journaltrack.services.UserService;

import javax.validation.Valid;
import java.security.Principal;

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
        if (bindingResult.hasErrors()) {
            return "user_create";
        }
        userService.create(form);
        return "redirect:/";
    }

    @GetMapping(value = "/subscribe")
    public String subscribe(Model model, Principal principal) {
        model.addAttribute("form", new UserSubscribeForm());
        model.addAttribute("orders", orderService.findAll(principal.getName()));
        return "subscribe";
    }

    @PostMapping(value = "/subscribe")
    public String subscribe(@ModelAttribute("form") UserSubscribeForm form) {
        userService.subscribe(form);
        return "redirect:/subscribe";
    }
}
