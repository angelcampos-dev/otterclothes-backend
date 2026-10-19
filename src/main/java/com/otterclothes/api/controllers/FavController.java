package com.otterclothes.api.controllers;

import com.otterclothes.api.models.Fav;
import com.otterclothes.api.repository.FavRepository;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{id}")
    public ResponseEntity<Fav> updateFav(@PathVariable Integer id, @RequestBody Fav fav) {
        if (!favRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        fav.setFavsId(id);
        return ResponseEntity.ok(favRepository.save(fav));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFav(@PathVariable Integer id) {
        if (!favRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        favRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}