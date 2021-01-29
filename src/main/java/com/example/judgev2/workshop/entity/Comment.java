package com.example.judgev2.workshop.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
    private Integer score;
    private String textContent;
    @ManyToOne
    private User author;
    @ManyToOne
    private Homework homework;
}
