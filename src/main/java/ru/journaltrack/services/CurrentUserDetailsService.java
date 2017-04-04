package ru.journaltrack.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.journaltrack.domain.CurrentUser;
import ru.journaltrack.domain.db.User;

@Service
public class CurrentUserDetailsService implements UserDetailsService{
    @Autowired
    private UserService userService;
    @Override
    public CurrentUser loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(name).orElseThrow(()->new UsernameNotFoundException("User"+name+" was not found"));
        return new CurrentUser(user);
    }
}
