package com.example.UFO.Encounters.service;

import com.example.UFO.Encounters.model.entities.Ufo;
import com.example.UFO.Encounters.repository.UfoRepository;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UfoService {

    private final UfoRepository ufoRepository;


    public Ufo create(Ufo ufo) {
        return ufoRepository.save(ufo);
    }

    public void delete(Long id) {
        ufoRepository.deleteById(id);
    }

    public Ufo get(Long id) {
        return ufoRepository.findUfoById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Ufo"));
    }

    public Iterable<Ufo> getAll() {
        return ufoRepository.findAll();
    }

    public Ufo updateUfo(Long id, Ufo updatedUfo) {
        Ufo existingUfo = get(id);

        existingUfo.setCharacteristics(updatedUfo.getCharacteristics());
        existingUfo.setAmount(updatedUfo.getAmount());
        existingUfo.setColor(updatedUfo.getColor());
        existingUfo.setShape(updatedUfo.getShape());
        existingUfo.setSize(updatedUfo.getSize());
        existingUfo.setDriveType(updatedUfo.getDriveType());

        return ufoRepository.save(existingUfo);
    }
}

