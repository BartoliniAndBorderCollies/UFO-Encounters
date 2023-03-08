package com.example.UFO.Encounters.repository;

import com.example.UFO.Encounters.model.entities.AirForce;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AirForceRepository extends CrudRepository<AirForce, Long> {

    List<AirForce> findAirForceByAircraftType(String aircraftType);
    List<AirForce> findAirForceByAircraftTypeAndOrders(String aircraftType, String orders);
    Optional<AirForce> findAirForceById (Long id);



}
