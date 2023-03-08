package com.example.UFO.Encounters.model.entities;

import com.example.UFO.Encounters.model.Sex;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity //TODO: dla przypomnienia encję daję wszedzie gdzie zapisuję dane w bazie danych.
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue // default strategy=GenerationType.SEQUENCE -> IDENTITY (dodaje po jednym)
    private Long id;
    private String accountName;
    private String name;
    @Enumerated //TODO: taka adnotacja bo sex jest enumem :).
    private Sex sex;
    private Integer age;
    private Boolean witness;

}
