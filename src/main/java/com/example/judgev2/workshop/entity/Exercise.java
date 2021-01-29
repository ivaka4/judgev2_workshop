package com.example.judgev2.workshop.entity;

import org.springframework.boot.context.properties.NestedConfigurationProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "exercises")
public class Exercise extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "started_on")
    private LocalDateTime startedOn;
    @Column(name = "due_date")
    private LocalDateTime dueDate;
}
