package com.example.UFO.Encounters.model.entities;

import com.example.UFO.Encounters.model.DescriptionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Locale;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class EncounterDescription {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User submittedBy; //TODO: nie wiem jak to uwzględnić w postmanie w Jsonie
    private Locale countryLocation;
    private String GpsCoordinates;
    private LocalDateTime date; //TODO: nie wiem jak to uwzględnić w postmanie w Jsonie
    private String story;
    private Boolean dayTime;
    private Integer altitude;
    private Integer speed; //TODO: tutaj też pewnie jakaś walidacja jest potrzebna, albo coś co precyzuje czy mph, czy kph czy machy czy co.
    private String result;
    private DescriptionStatus status;

    @ManyToOne
    private AirForce airForce; //TODO: nie wiem jak to uwzględnić w postmanie w Jsonie
}
