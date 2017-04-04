package ru.journaltrack.repository;


import org.springframework.data.repository.CrudRepository;
import ru.journaltrack.domain.db.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long>{
    List<User> findByUsernameNotLike(String username);
    Optional<User> findByUsername(String username);
}
