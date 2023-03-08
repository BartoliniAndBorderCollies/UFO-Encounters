package com.example.UFO.Encounters.controller;


import com.example.UFO.Encounters.model.entities.AirForce;
import com.example.UFO.Encounters.repository.AirForceRepository;
import com.example.UFO.Encounters.service.AirForceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/airForce")
@AllArgsConstructor

public class AirForceController {

    private final AirForceService airForceService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AirForce addAirForce(@RequestBody AirForce airForce) {
        return airForceService.create(airForce);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAirForce(@PathVariable("id") Long id) {
        airForceService.delete(id);
    }

    @GetMapping("/{id}")
    public AirForce getAirForce(@PathVariable("id") Long id) {
        return airForceService.get(id);
    }

    @GetMapping
    public Iterable<AirForce> getAllAirForce() {
        return airForceService.getAll();
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateAirForce(@PathVariable Long id, @RequestBody AirForce updatedAirForce) {
       airForceService.updateAirForce(id, updatedAirForce);

    }


//TODO: co to jest dokładnie @oneToMany i @ManyToOne i co to robi? mam to w AirForce modelu.

}
