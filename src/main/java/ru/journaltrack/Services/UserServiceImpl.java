package ru.journaltrack.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.journaltrack.domain.User;
import ru.journaltrack.domain.UserCreateForm;
import ru.journaltrack.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public Optional<User> getUserById(long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findByUsernameNotLike(String username) {
        return userRepository.findByUsernameNotLike(username);
    }


    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setAuthorities(form.getAuthorities());
        user.setMail(form.getMail());
        user.setPassword(encoder.encode(form.getPassword()));
        return userRepository.save(user);
    }
}
