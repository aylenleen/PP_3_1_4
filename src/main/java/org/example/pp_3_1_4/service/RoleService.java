package org.example.pp_3_1_4.service;



import org.example.pp_3_1_4.model.Role;
import org.example.pp_3_1_4.model.User;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    List<String> getRolesNames(User user);
    public void addNewRole(Role role);
    public Role findByName(String roleName);
}
