package com.example.UFO.Encounters.repository;

import com.example.UFO.Encounters.model.entities.Ufo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UfoRepository extends CrudRepository<Ufo, Long> {
    List<Ufo> findUfoBySize(String size);
    List<Ufo> findUfoByAmount(Integer amount);

    Optional<Ufo> findUfoById(Long id); //TODO: tutaj dodałem optional bo był problem w controllerze, że tam jest optional a tutaj było list.


}
