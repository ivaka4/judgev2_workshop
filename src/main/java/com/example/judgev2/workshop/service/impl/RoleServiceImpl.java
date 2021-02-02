package com.example.judgev2.workshop.service.impl;

import com.example.judgev2.workshop.model.entity.Role;
import com.example.judgev2.workshop.model.entity.RoleNameEnum;
import com.example.judgev2.workshop.repository.RoleRepository;
import com.example.judgev2.workshop.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {
        if (roleRepository.count() == 0){
            Role admin = new Role(RoleNameEnum.ADMIN);
            Role user = new Role(RoleNameEnum.USER);
            roleRepository.save(admin);
            roleRepository.save(user);
        }
    }

    @Override
    public Role findRole(RoleNameEnum roleNameEnum) {

        return this.roleRepository.findByName(roleNameEnum).orElse(null);
    }
}
