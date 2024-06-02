package com.example.hexagonal_architecture_example.infrastructure.rest.spring.resources;

import com.example.hexagonal_architecture_example.application.service.UserService;
import com.example.hexagonal_architecture_example.domain.User;
import com.example.hexagonal_architecture_example.infrastructure.rest.spring.dto.UserDto;
import com.example.hexagonal_architecture_example.infrastructure.rest.spring.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class Resources {

    private final UserService userService;

    private final UserMapper userMapper;

    @GetMapping("users/user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {

        return new ResponseEntity<>(userMapper.toDto(userService.getUser(id)), HttpStatus.OK);

    }

    @PostMapping("users")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {

        User user = userMapper.toDomain(userDto);

        return new ResponseEntity<>(userMapper.toDto(userService.saveUser(user)),
                HttpStatus.CREATED);

    }

}
