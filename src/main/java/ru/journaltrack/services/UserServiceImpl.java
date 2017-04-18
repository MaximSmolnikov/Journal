package ru.journaltrack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.journaltrack.domain.db.Order;
import ru.journaltrack.domain.db.User;
import ru.journaltrack.domain.form.UserCreateForm;
import ru.journaltrack.domain.form.UserSubscribeForm;
import ru.journaltrack.repository.UserRepository;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private OrderService orderService;

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

    @Override
    public void subscribe(UserSubscribeForm form) {
        User user = userRepository.findByUsername(form.getUsername()).get();
        Order order = orderService.findOne(form.getOrderId());
        user.getOrders().add(order);
        order.getUsers().add(user);
        userRepository.save(user);
    }

    @Override
    public void update(UserCreateForm form, Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).get();
        user.setUsername(form.getUsername());
        user.setMail(form.getMail());
        user.setAuthorities(form.getAuthorities());
        userRepository.save(user);
    }
}
