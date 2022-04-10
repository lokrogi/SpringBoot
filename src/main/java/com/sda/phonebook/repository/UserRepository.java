package com.sda.phonebook.repository;

import com.sda.phonebook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUserName(String username);
    User findByUserName(String username);
}
