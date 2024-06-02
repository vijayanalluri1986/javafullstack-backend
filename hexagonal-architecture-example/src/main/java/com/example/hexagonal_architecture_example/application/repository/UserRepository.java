package com.example.hexagonal_architecture_example.application.repository;


import com.example.hexagonal_architecture_example.domain.User;

public interface UserRepository {

    User findById(Long id);

    User save(User user);

}
