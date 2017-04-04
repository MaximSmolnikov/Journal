package ru.journaltrack.domain.db;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@Getter
public abstract class AbstractIdentfied {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
