package com.example.ecomm.user.domain.model.repository;

import com.example.ecomm.user.domain.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    @Query("select u from User u where u.email = :email")
    User findByEmail(String email);
}