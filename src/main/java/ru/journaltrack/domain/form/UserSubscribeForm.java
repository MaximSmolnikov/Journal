package ru.journaltrack.domain.form;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class UserSubscribeForm {
    @NotEmpty(message = "Поле не может быть пустое")
    public String username;
    @NotEmpty
    public Long orderId;
}
