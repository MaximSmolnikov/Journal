package ru.journaltrack.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.journaltrack.domain.db.Order;

import java.util.List;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
    @Query(value = "SELECT o FROM #{#entityName} o JOIN o.users u  WHERE u.username=?1")
    Page<Order> findOrdersBelongsUsername(String username,Pageable pageable);

    @Query(value = "SELECT o FROM #{#entityName} o JOIN o.users u  WHERE u.username=?1")
    List<Order> findOrdersBelongsUsername(String username);
}
