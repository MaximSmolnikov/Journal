package ru.journaltrack.api;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.journaltrack.Domain.State;

public interface StateRepository extends PagingAndSortingRepository<State,Long> {
}
