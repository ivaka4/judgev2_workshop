package com.example.judgev2.workshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private RoleNameEnum name;
}
