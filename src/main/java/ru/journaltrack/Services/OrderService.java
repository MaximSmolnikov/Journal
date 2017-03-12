package ru.journaltrack.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import ru.journaltrack.domain.Order;
import ru.journaltrack.repository.OrderRepository;

@Service
public class OrderService  {
    @Autowired
    OrderRepository orderRepository;
    public Page<Order> getPage(Pageable pageable, String username) {
        return orderRepository.findOrdersBelongsUsername(username,pageable);
    }
    public void save(Order order){
        orderRepository.save(order);
    }
    public Order findOne(Long id){
        return orderRepository.findOne(id);
    }
}
