package com.example.judgev2.workshop.init;

import com.example.judgev2.workshop.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {
    private final RoleService roleService;

    public DatabaseInit(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        roleService.initRoles();
    }
}
