package com.example.UFO.Encounters.controller;

import com.example.UFO.Encounters.model.DescriptionStatus;
import com.example.UFO.Encounters.model.entities.EncounterDescription;
import com.example.UFO.Encounters.model.entities.User;
import com.example.UFO.Encounters.repository.EncounterRepository;
import com.example.UFO.Encounters.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("users/admin")
public class AdminController {

    private final UserRepository userRepository;
    private final EncounterRepository encounterRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addAdmin(@RequestBody User admin) {
        return userRepository.save(admin);
    }

//TODO: dobrze, że stworzyłem deleteAdmin czy było to osiagalne poprzez deleteUser? ale ściezka nie ta przecież, wiec jak?
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteAdmin(@PathVariable("id") Long id) {
        this.userRepository.deleteById(id);
    }


    @GetMapping("/encounters/{encounterStatusParam}")
    public List<EncounterDescription> getEncountersByStatus(@PathVariable DescriptionStatus encounterStatusParam) {
        return encounterRepository.findEncounterDescriptionByStatus(encounterStatusParam);
    }


    @PutMapping("/encounters/{encounterId}/{adminDecision}/")
    public void reviewAction(@PathVariable Long id, @PathVariable DescriptionStatus adminDecision) {
        Optional<EncounterDescription> optionalEncounterDescription = encounterRepository.findById(id);

        EncounterDescription encounterPresent = optionalEncounterDescription.orElseThrow(() -> new IllegalArgumentException("tu wpisujesz swój własny komunikat" + id));
        encounterPresent.setStatus(adminDecision);
        encounterRepository.save(encounterPresent);
    }


//TODO: wcześniej miałem tak na początku metody:

//    @PutMapping("/encounters/{encounterId")
//    public void reviewAction(@PathVariable Long id, @RequestBody DescriptionStatus adminDecision) {
//        Optional<EncounterDescription> optionalEncounterDescription = encounterRepository.findById(id);
////        if (optionalEncounterDescription.isEmpty()) {
////            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
////        }


}
