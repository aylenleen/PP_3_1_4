package org.example.pp_3_1_4.service;

import org.example.pp_3_1_4.dao.RoleRepository;
import org.example.pp_3_1_4.model.Role;
import org.example.pp_3_1_4.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public List<String> getRolesNames(User user) {
        return user.getRoles()
                .stream()
                .map(Role::getName)
                .toList();
    }

    @Transactional
    @Override
    public void addNewRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
