package com.example.hexagonal_architecture_example.application.service;

import com.example.hexagonal_architecture_example.application.repository.UserRepository;
import com.example.hexagonal_architecture_example.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public User getUser(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);

    }
}
