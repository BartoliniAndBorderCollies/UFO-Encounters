package com.example.UFO.Encounters.repository;

import com.example.UFO.Encounters.model.entities.AirForce;
import com.example.UFO.Encounters.model.DescriptionStatus;
import com.example.UFO.Encounters.model.entities.EncounterDescription;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EncounterRepository extends CrudRepository<EncounterDescription, Long> {
    List<EncounterDescription> findEncounterDescriptionByDate(String date);
    List<EncounterDescription> findEncounterDescriptionByCountryLocation(String countryLocation);
    List<EncounterDescription> findEncounterDescriptionByResult(String result);
    List<EncounterDescription> findEncounterDescriptionByAirForce(AirForce airForce); //TODO: w field jest to inaczej zdefioniowane
    List<EncounterDescription> findEncounterDescriptionByAirForceId(Long airForceId);
    List<EncounterDescription> findEncounterDescriptionByDateAndCountryLocation(String date, String countryLocation);

    List<EncounterDescription> findEncounterDescriptionByStatus(DescriptionStatus descriptionStatus);

    Optional<EncounterDescription> findEncounterDescriptionById(Long id);


}
