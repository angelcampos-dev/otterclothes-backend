package com.otterclothes.api.repository;

import com.otterclothes.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    Optional<User> findByUserEmail(String userEmail);


    // lo mismo JpaRepository spring boot nos da
    // todos los métodos crud básicos (.save, .findAll, .findById, .deleteById)
}
