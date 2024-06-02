package com.example.hexagonal_architecture_example.infrastructure.db.springdata.repository;

import com.example.hexagonal_architecture_example.application.repository.UserRepository;
import com.example.hexagonal_architecture_example.domain.User;
import com.example.hexagonal_architecture_example.infrastructure.db.springdata.mapper.UserEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserDboRepository implements UserRepository {

    private final SpringDataUserRepository userRepository;

    private final UserEntityMapper userMapper;

    @Override
    public User findById(Long id) {
        return userMapper.toDomain(userRepository.findById(id).orElseThrow());
    }

    @Override
    public User save(User user) {
        return userMapper.toDomain(userRepository.save(userMapper.toDbo(user)));
    }
}
