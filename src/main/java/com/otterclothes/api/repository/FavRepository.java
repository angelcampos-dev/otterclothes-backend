package com.otterclothes.api.repository;

import com.otterclothes.api.models.Fav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavRepository extends JpaRepository<Fav, Integer> {
}