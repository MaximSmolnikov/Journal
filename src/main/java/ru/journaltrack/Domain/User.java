package ru.journaltrack.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractIdentfied implements UserDetails{
  private String username;
  private String password;
  private String mail;
  @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
  @Enumerated(EnumType.STRING)
  @CollectionTable(name = "Roles")
  private List<Role> authorities;
  @ManyToMany
  @JoinTable(name = "user_order",
      joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "id_order", referencedColumnName = "id"))
  private List<Order> orders;
  private boolean accountNonExpired;
  private boolean accountNonLocked;
  private boolean credentialsNonExpired;
  private boolean enabled;
}
