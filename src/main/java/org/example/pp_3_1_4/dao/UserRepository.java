package org.example.pp_3_1_4.dao;

import org.example.pp_3_1_4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u left join fetch u.roles where u.username =:username")
    User findByUsername(String username);
    Optional<User> findById(Long id);
}
