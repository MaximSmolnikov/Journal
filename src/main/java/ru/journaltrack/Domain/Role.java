package ru.journaltrack.Domain;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{
    ROLE_ADMIN,ROLE_USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
