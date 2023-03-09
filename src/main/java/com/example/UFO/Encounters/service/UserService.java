package com.example.UFO.Encounters.service;

import com.example.UFO.Encounters.model.entities.User;
import com.example.UFO.Encounters.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User get(Long id) {
        return userRepository.findUserById(id).orElseThrow(() -> new ObjectNotFoundException(id, "user"));
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User updatedUser) {
        User existingUser = get(id);

        existingUser.setAccountName(updatedUser.getAccountName());
        existingUser.setName(updatedUser.getName());
        existingUser.setSex(updatedUser.getSex());
        existingUser.setAge(updatedUser.getAge());
        existingUser.setWitness(updatedUser.getWitness());

        return userRepository.save(existingUser);
    }
}
