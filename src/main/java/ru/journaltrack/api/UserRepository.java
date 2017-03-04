package ru.journaltrack.api;


import org.springframework.data.repository.CrudRepository;
import ru.journaltrack.Domain.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long>{
    Optional<User> findByUsername(String username);
}
