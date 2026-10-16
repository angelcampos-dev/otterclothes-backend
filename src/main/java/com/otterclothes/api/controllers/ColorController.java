package com.otterclothes.api.controllers;

import com.otterclothes.api.models.Color;
import com.otterclothes.api.repository.ColorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
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
}