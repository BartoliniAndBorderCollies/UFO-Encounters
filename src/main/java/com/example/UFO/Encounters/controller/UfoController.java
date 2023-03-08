package com.example.UFO.Encounters.controller;

import com.example.UFO.Encounters.model.entities.Ufo;
import com.example.UFO.Encounters.model.entities.User;
import com.example.UFO.Encounters.service.UfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.example.UFO.Encounters.repository.UfoRepository;

import java.util.Optional;

@RestController
@RequestMapping("/ufo")
@AllArgsConstructor
public class UfoController {

    private final UfoService ufoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ufo addUfo(@RequestBody Ufo ufo) {
        return ufoService.create(ufo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUfo(@PathVariable("id") Long id) {
        this.ufoService.delete(id); //TODO: tutaj musi być this czy może być bez? bo coś czuję, że może być bez this
    }


    @GetMapping("/{id}")
    public Ufo getUfo(@PathVariable("id") Long id) {
        return ufoService.get(id);
    }

    @GetMapping
    public Iterable<Ufo> getAllUfo() {
        return ufoService.getAll();
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUfo(@PathVariable Long id, @RequestBody Ufo updatedUfo) {
        ufoService.updateUfo(id, updatedUfo);

    }


}


