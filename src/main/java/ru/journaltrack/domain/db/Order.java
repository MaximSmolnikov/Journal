package ru.journaltrack.domain.db;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends AbstractIdentfied{

  private String name;

  @OneToMany(fetch = FetchType.EAGER,mappedBy = "order",cascade = CascadeType.ALL)
  private List<State> states;

  @ManyToMany(fetch = FetchType.EAGER,mappedBy = "orders")
  private Set<User> users = new HashSet<>();

  private boolean status;

  @Override
  public String toString() {
    return "Order{" +
        "name='" + name + '\'' +
        ", states=" + states +
        ", status=" + status +
        '}';
  }
}
