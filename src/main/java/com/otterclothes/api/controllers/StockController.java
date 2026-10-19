package com.otterclothes.api.controllers;

import com.otterclothes.api.models.Stock;
import com.otterclothes.api.repository.StockRepository;
import org.springframework.http.ResponseEntity;
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
        stock.setStockId(null);
        return stockRepository.save(stock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Integer id, @RequestBody Stock stock) {
        if (!stockRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        stock.setStockId(id);
        return ResponseEntity.ok(stockRepository.save(stock));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Integer id) {
        if (!stockRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        stockRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
