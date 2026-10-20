package com.otterclothes.api.controllers;

import com.otterclothes.api.models.Color;
import com.otterclothes.api.repository.ColorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
@CrossOrigin(origins = "*")
public class ColorController {

    private final ColorRepository colorRepository;

    public ColorController(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @GetMapping
    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    @PostMapping
    public Color createColor(@RequestBody Color color) {
        color.setColorId(null);
        return colorRepository.save(color);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Color> updateColor(@PathVariable Integer id, @RequestBody Color color) {
        if (!colorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        color.setColorId(id);
        return ResponseEntity.ok(colorRepository.save(color));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColor(@PathVariable Integer id) {
        if (!colorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        colorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}