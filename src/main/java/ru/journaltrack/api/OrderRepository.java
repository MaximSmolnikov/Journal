package ru.journaltrack.api;

import org.springframework.data.repository.PagingAndSortingRepository;

import ru.journaltrack.pojo.Order;

import java.util.List;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

}
