package com.example.UFO.Encounters.controller;

import com.example.UFO.Encounters.model.Sex;
import com.example.UFO.Encounters.model.entities.User;
import com.example.UFO.Encounters.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.example.UFO.Encounters.repository.UserRepository;

import java.util.Optional;

@RequestMapping("/users")
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        return userService.create(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") Long id) {
        this.userService.delete(id);

    }


    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.get(id);
    }


    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAll();
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        userService.updateUser(id, updatedUser);


    }

//    @GetMapping("/search")
//    public Iterable<User> searchUser(@RequestParam(required = false) String name, @RequestParam(required = false) String accountName, @RequestParam(required = false) Sex sex, @RequestParam(required = false) Integer age) {
//
//        //TODO: to poniższe nie jest fajne, bo jak bede szukał po kilku parametrach na raz to bedzie masakra.
//        //TODO: żeby było ładnie trzeba uzyć kryteria builder - to może bedzie oddzielnym tematem, bo gruby temat.
//        Iterable<User> users;
//        if (!ObjectUtils.isEmpty(name)) {
//            users = userRepository.findUserByName(name);
//        } else if (!ObjectUtils.isEmpty(accountName)) {
//            users = userRepository.findUserByAccountName(accountName);
//        } else if (!ObjectUtils.isEmpty(sex)) {
//            users = userRepository.findUserBySex(sex);
//        } else if (!ObjectUtils.isEmpty(age) && !ObjectUtils.isEmpty(sex)) {
//            users = userRepository.findUserByAgeAndSex(age, sex);
//        } else {
//            users = userRepository.findAll();
//        }
//
//        return users;
//
//
//
//    }





}
