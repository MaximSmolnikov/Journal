package ru.journaltrack.Services;


import ru.journaltrack.domain.User;
import ru.journaltrack.domain.UserCreateForm;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(long id);

    Optional<User> getUserByUsername(String username);

    List<User> findByUsernameNotLike(String username);

    User create(UserCreateForm form);

}
