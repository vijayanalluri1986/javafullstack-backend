package com.example.hexagonal_architecture_example.infrastructure.rest.spring.mapper;

import com.example.hexagonal_architecture_example.domain.User;
import com.example.hexagonal_architecture_example.infrastructure.rest.spring.dto.UserDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    UserDto toDto(User user);

    User toDomain(UserDto userDto);
}
