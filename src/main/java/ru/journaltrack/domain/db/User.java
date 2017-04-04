package ru.journaltrack.domain.db;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.journaltrack.domain.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractIdentfied {
    private String username;
    private String password;
    private String mail;
    @Enumerated(EnumType.STRING)
    private Role authorities;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_order",
            joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_order", referencedColumnName = "id"))
    private List<Order> orders = new ArrayList<>();

}
