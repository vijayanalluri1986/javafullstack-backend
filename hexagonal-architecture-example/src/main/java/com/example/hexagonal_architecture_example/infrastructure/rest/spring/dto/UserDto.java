package com.example.hexagonal_architecture_example.infrastructure.rest.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private Long id;

    private String name;

    private String address;
}
