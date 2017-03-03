package ru.journaltrack.api;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.journaltrack.pojo.State;

public interface StateRepository extends PagingAndSortingRepository<State,Long> {
}
