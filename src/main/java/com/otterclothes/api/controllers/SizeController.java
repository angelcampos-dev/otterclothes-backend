package com.otterclothes.api.controllers;

import com.otterclothes.api.models.Size;
import com.otterclothes.api.repository.SizeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sizes")
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
}