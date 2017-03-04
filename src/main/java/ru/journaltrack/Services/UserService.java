package ru.journaltrack.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.journaltrack.api.UserRepository;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByUsername(name).orElseThrow(()->new UsernameNotFoundException("User"+name+" was not found"));
    }
}
