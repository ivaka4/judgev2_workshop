package com.example.judgev2.workshop.repository;

import com.example.judgev2.workshop.model.entity.Role;
import com.example.judgev2.workshop.model.entity.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleNameEnum roleNameEnum);
}
