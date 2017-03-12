package ru.journaltrack.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.journaltrack.domain.State;

public interface StateRepository extends PagingAndSortingRepository<State,Long> {
}
