package com.otterclothes.api.controllers;

import com.otterclothes.api.models.Size;
import com.otterclothes.api.repository.SizeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sizes")
@CrossOrigin(origins = "*")
public class SizeController {

    private final SizeRepository sizeRepository;

    public SizeController(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    @GetMapping
    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }

    @PostMapping
    public Size createSize(@RequestBody Size size) {
        size.setSizeId(null);
        return sizeRepository.save(size);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Size> updateSize(@PathVariable Integer id, @RequestBody Size size) {
        if (!sizeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        size.setSizeId(id);
        return ResponseEntity.ok(sizeRepository.save(size));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSize(@PathVariable Integer id) {
        if (!sizeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        sizeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}