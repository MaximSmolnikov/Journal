package ru.journaltrack.api;

import org.springframework.data.repository.PagingAndSortingRepository;

import ru.journaltrack.Domain.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

}
