package com.example.judgev2.workshop.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private RoleNameEnum name;

}
