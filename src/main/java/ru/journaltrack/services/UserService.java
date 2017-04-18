package ru.journaltrack.services;


import ru.journaltrack.domain.db.User;
import ru.journaltrack.domain.form.UserCreateForm;
import ru.journaltrack.domain.form.UserSubscribeForm;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(long id);

    Optional<User> getUserByUsername(String username);

    List<User> findByUsernameNotLike(String username);

    User create(UserCreateForm form);

    void subscribe(UserSubscribeForm form);

    void update(UserCreateForm form, Principal principal);

}
