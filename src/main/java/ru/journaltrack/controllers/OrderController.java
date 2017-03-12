package ru.journaltrack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.journaltrack.repository.OrderRepository;
import ru.journaltrack.Services.OrderService;
import ru.journaltrack.repository.StateRepository;
import ru.journaltrack.domain.Order;
import ru.journaltrack.domain.State;

import java.security.Principal;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private StateRepository stateRepository;

    @RequestMapping(value = "/orders")
    public String home(Pageable pageable, Model model, Principal principal) {
        Page<Order> page = orderService.getPage(pageable,principal.getName());
        System.out.println(page.getContent());
        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("orders", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);


        model.addAttribute("order",new Order());
        return "index";
    }

    @RequestMapping(value = "/add/{id}")
    public @ResponseBody void addState(@RequestBody State state , @PathVariable Long id){
        System.out.println(id);
        Order order = orderService.findOne(id);
        state.setOrder(order);
        System.out.println(state);
        stateRepository.save(state);
    }
    @PostMapping(value = "/neworder")
    public String addOrder(@ModelAttribute Order order){
        orderService.save(order);
        return "redirect:/orders";
    }
}
