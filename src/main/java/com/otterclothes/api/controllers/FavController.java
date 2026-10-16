package com.otterclothes.api.controllers;

import com.otterclothes.api.models.Fav;
import com.otterclothes.api.repository.FavRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favs")
public class FavController {

    private final FavRepository favRepository;

    public FavController(FavRepository favRepository) {
        this.favRepository = favRepository;
    }

    @GetMapping
    public List<Fav> getAllFavs() {
        return favRepository.findAll();
    }

    @PostMapping
    public Fav createFav(@RequestBody Fav fav) {
        fav.setFavsId(null);
        return favRepository.save(fav);
    }
}