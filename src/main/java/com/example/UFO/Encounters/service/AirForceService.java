package com.example.UFO.Encounters.service;

import com.example.UFO.Encounters.model.entities.AirForce;
import com.example.UFO.Encounters.repository.AirForceRepository;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class AirForceService {

    private final AirForceRepository airForceRepository;

    public AirForce create(AirForce airForce) {
        return airForceRepository.save(airForce);
    }

    public void delete(Long id) {
        airForceRepository.deleteById(id);
    }

    public AirForce get(Long id) {
        return airForceRepository.findAirForceById(id).orElseThrow(()-> new ObjectNotFoundException(id, "AirForce"));
    }

    public Iterable<AirForce> getAll() {
        return airForceRepository.findAll();
    }

    public void updateAirForce(Long id, AirForce updatedAirForce) {
        AirForce existingAirForce = get(id);

        existingAirForce.setAirForceName(updatedAirForce.getAirForceName());
        existingAirForce.setCountry(updatedAirForce.getCountry());
        existingAirForce.setAircraftType(updatedAirForce.getAircraftType());
        existingAirForce.setOrders(updatedAirForce.getOrders());
        existingAirForce.setEncounterDescription(updatedAirForce.getEncounterDescription());

        airForceRepository.save(existingAirForce);

    }


}
