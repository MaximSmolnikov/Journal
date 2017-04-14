package ru.journaltrack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String welcome(){return "welcome";}

    @GetMapping("/help")
    public String help(Model model) {
        //text HELP tutorial
        return "help";
    }
}
