package com.example.UFO.Encounters.repository;

import com.example.UFO.Encounters.model.Sex;
import com.example.UFO.Encounters.model.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserById(Long id);

    List<User> findUserByName(String name);

    List<User> findUserByAccountName(String accountName);

    List<User> findUserBySex(Sex sex);

    List<User> findUserByAgeAndSex(Integer age, Sex sex);


}
