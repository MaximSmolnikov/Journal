package ru.journaltrack.domain.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"order"})
public class State extends AbstractIdentfied {

  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private Date date;

  private String description;

  @ManyToOne
  @JoinColumn(name = "id_order")
  private Order order;

  private boolean status;

  @Override
  public String toString() {
    return "State{" +
            "date=" + date +
            ", description='" + description + '\'' +
            ", order=" + order.getName() +
            '}';
  }
}
