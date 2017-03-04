package ru.journaltrack.Domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@Getter
public abstract class AbstractIdentfied {
    @Id
    @GeneratedValue
    private Long id;
}
