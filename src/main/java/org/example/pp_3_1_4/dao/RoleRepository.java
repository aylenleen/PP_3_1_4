package org.example.pp_3_1_4.dao;

import org.example.pp_3_1_4.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
