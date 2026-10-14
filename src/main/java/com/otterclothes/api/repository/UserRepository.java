package com.otterclothes.api.repository;

import com.otterclothes.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // lo mismo JpaRepository spring boot nos da
    // todos los métodos crud básicos (.save, .findAll, .findById, .deleteById)
}
