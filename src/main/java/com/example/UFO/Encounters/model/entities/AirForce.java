package com.example.UFO.Encounters.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Locale;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AirForce {
    @Id
    @GeneratedValue
    private Long id;
    private String airForceName;
    private Locale country;
    private String aircraftType;
    private String orders;

    @OneToMany
    private List<EncounterDescription> encounterDescription;
}
