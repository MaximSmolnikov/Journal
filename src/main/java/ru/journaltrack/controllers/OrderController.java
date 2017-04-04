package ru.journaltrack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.journaltrack.domain.db.Order;
import ru.journaltrack.domain.db.State;
import ru.journaltrack.repository.StateRepository;
import ru.journaltrack.services.OrderService;

import java.security.Principal;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private StateRepository stateRepository;

    @GetMapping(value = "/orders")
    public String home(Pageable pageable, Model model, Principal principal) {
        Page<Order> page = orderService.getPage(pageable,principal.getName());

        int begin = Math.max(1, page.getNumber() - 5);
        model.addAttribute("orders", page);
        model.addAttribute("beginIndex", begin);

        model.addAttribute("order",new Order());
        return "index";
    }

    @PostMapping(value = "/add/{id}")
    public @ResponseBody void addState(@RequestBody State state , @PathVariable Long id){
        Order order = orderService.findOne(id);
        state.setOrder(order);
        stateRepository.save(state);
    }
    @PostMapping(value = "/neworder")
    public String addOrder(@ModelAttribute Order order, Principal principal) {
        orderService.save(order, principal);
        return "redirect:/orders";
    }
}
