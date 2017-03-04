package ru.journaltrack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.journaltrack.api.OrderRepository;
import ru.journaltrack.api.OrderService;
import ru.journaltrack.api.StateRepository;
import ru.journaltrack.Domain.Order;
import ru.journaltrack.Domain.State;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/orders")
    public String home(Model model,@RequestParam(value = "page",defaultValue = "1") int pageNumber) {
        Page<Order> page = orderService.getPage(pageNumber);

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
