package com.example.judgev2.workshop.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "homework")
public class Homework extends BaseEntity{
    private LocalDateTime addedOn;
    private String gitAddress;
    @ManyToOne
    private User author;
    @ManyToOne
    private Exercise exercise;
}
