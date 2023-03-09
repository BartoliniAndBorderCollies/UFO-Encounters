package com.example.UFO.Encounters.controller;

import com.example.UFO.Encounters.model.entities.EncounterDescription;
import com.example.UFO.Encounters.service.EncounterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/encounter")
@RestController
@AllArgsConstructor
public class EncounterController {

    private final EncounterService encounterService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EncounterDescription addEncounter(@RequestBody EncounterDescription encounterDescription) {
        return encounterService.create(encounterDescription);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEncounter(@PathVariable("id") Long id) {
        encounterService.delete(id);
    }

    @GetMapping("/{id}")
    public EncounterDescription getEncounter(@PathVariable("id") Long id) {
        return encounterService.get(id);

    }

    @GetMapping
    public Iterable<EncounterDescription> getAllEncounters() {
        return encounterService.getAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EncounterDescription updateEncounterDescription(@PathVariable Long id, @RequestBody EncounterDescription updatedEncounter) {
        return encounterService.updateEncounter(id, updatedEncounter);

    }


}
