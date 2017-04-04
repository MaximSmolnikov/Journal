package ru.journaltrack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.journaltrack.domain.db.Order;
import ru.journaltrack.domain.db.User;
import ru.journaltrack.repository.OrderRepository;
import ru.journaltrack.repository.UserRepository;

import java.security.Principal;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    public Page<Order> getPage(Pageable pageable, String username) {
        return orderRepository.findOrdersBelongsUsername(username, pageable);
    }

    public void save(Order order, Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).get();
        user.getOrders().add(order);
        userRepository.save(user);
    }

    public Order findOne(Long id) {
        return orderRepository.findOne(id);
    }

    public List<Order> findAll(String username) {
        return orderRepository.findOrdersBelongsUsername(username);
    }
}
