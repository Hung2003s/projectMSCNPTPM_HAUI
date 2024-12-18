package com.minejava.userservice.dto;

import org.springframework.stereotype.Service;

import com.minejava.userservice.model.User;
import com.minejava.userservice.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserDataService {
    private final UserRepository userRepository;

    public UserDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    public Mono<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Mono<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Mono<Boolean> isUserExists(String id) {
        return userRepository.existsById(id);
    }

    public Mono<Boolean> isUserExists(String username, String email) {
        return userRepository.existsByUsernameOrEmail(username, email);
    }

    public Mono<User> saveUser(User user) {
        return userRepository.save(user);
    }

    public Mono<Void> deleteUserById(String id) {
        return userRepository.deleteById(id);
    }

    public Mono<Void> deleteAllUsers() {
        return userRepository.deleteAll();
    }

    public Mono<Long> countAllUsers() {
        return userRepository.count();
    }
}
