package ru.journaltrack.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends AbstractIdentfied{
  private String name;
  @OneToMany(fetch = FetchType.EAGER,mappedBy = "order",cascade = CascadeType.ALL)
  private List<State> states;

  @Override
  public String toString() {
    return "Order{" +
            "name='" + name + '\'' +
            ", states=" + states +
            '}';
  }
}
