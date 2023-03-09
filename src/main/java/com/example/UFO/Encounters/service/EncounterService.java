package com.example.UFO.Encounters.service;

import com.example.UFO.Encounters.model.entities.EncounterDescription;
import com.example.UFO.Encounters.repository.EncounterRepository;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EncounterService {

    private final EncounterRepository encounterRepository;

    public EncounterDescription create(EncounterDescription encounterDescription) {
        return encounterRepository.save(encounterDescription);
    }

    public void delete(Long id) {
        encounterRepository.deleteById(id);
    }

    public EncounterDescription get(Long id) {
        return encounterRepository.findEncounterDescriptionById(id).orElseThrow(() -> new ObjectNotFoundException(id, "EncounterDescription"));
    }

    public Iterable<EncounterDescription> getAll() {
        return encounterRepository.findAll();
    }

    public EncounterDescription updateEncounter(Long id, EncounterDescription updatedEncounter) {
        EncounterDescription existingEncounter = get(id);

        existingEncounter.setCountryLocation(updatedEncounter.getCountryLocation());
        existingEncounter.setGpsCoordinates(updatedEncounter.getGpsCoordinates());
        existingEncounter.setDate(updatedEncounter.getDate());
        existingEncounter.setStory(updatedEncounter.getStory());
        existingEncounter.setDayTime(updatedEncounter.getDayTime());
        existingEncounter.setAltitude(updatedEncounter.getAltitude());
        existingEncounter.setSpeed(updatedEncounter.getSpeed());
        existingEncounter.setResult(updatedEncounter.getResult());
        existingEncounter.setStatus(updatedEncounter.getStatus());
        existingEncounter.setAirForce(updatedEncounter.getAirForce());

        return encounterRepository.save(existingEncounter);


    }

}