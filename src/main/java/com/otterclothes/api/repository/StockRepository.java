package com.otterclothes.api.repository;

import com.otterclothes.api.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    boolean existsByProduct_ProductId(Integer productId);

    // con JpaRepository, spring boot nos da
    // todos los métodos crud básicos
}
