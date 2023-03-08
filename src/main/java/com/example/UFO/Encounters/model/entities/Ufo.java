package com.example.UFO.Encounters.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor

public class Ufo {

    @Id
    @GeneratedValue
    private Long id;
    private String characteristics;
    private String size;
    private Integer amount;
    private String driveType;
    private String color;
    private String shape;


}
