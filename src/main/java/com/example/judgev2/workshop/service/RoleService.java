package com.example.judgev2.workshop.service;

import com.example.judgev2.workshop.model.entity.Role;
import com.example.judgev2.workshop.model.entity.RoleNameEnum;

public interface RoleService {

    void initRoles();

    Role findRole(RoleNameEnum roleNameEnum);
}
