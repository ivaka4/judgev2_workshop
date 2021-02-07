package com.example.judgev2.workshop.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
public class Comment extends BaseEntity {
    private Integer score;
    private String textContent;
    @ManyToOne
    private User author;
    @ManyToOne
    private Homework homework;
}
