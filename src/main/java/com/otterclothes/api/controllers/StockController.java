package com.otterclothes.api.controllers;


import com.otterclothes.api.models.Stock;
import com.otterclothes.api.repository.StockRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final StockRepository stockRepository;

    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    // crud pra ver todo el inventario
    @GetMapping
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    // crud creat para guardar un producto en inventario
    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return stockRepository.save(stock);
    }
}
