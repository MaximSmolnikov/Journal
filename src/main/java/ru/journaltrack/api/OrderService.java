package ru.journaltrack.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.journaltrack.Domain.Order;

@Service
public class OrderService  {
    private static final int PAGE_SIZE = 2;
    @Autowired
    OrderRepository orderRepository;
    public Page<Order> getPage(Integer pageNumber) {
        PageRequest pageRequest=
                new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "name");
        return orderRepository.findAll(pageRequest);
    }
    public void save(Order order){
        orderRepository.save(order);
    }
    public Order findOne(Long id){
        return orderRepository.findOne(id);
    }
}
