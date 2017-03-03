package ru.journaltrack.pojo;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractIdentfied {
  private String login;
  private String password;
  private String mail;
  private String role;
  @ManyToMany
  @JoinTable(name = "user_order",
      joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "id_order", referencedColumnName = "id"))
  private List<Order> orders;
}
