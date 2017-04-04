package ru.journaltrack.domain;


import org.springframework.security.core.authority.AuthorityUtils;
import ru.journaltrack.domain.db.User;

public class CurrentUser extends  org.springframework.security.core.userdetails.User{
    private User user;

    public CurrentUser(User user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getAuthorities().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getAuthorities();
    }
}
