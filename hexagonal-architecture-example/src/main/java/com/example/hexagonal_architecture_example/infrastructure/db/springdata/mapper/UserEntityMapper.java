package com.example.hexagonal_architecture_example.infrastructure.db.springdata.mapper;

import com.example.hexagonal_architecture_example.domain.User;
import com.example.hexagonal_architecture_example.infrastructure.db.springdata.dbo.UserEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserEntityMapper {

    User toDomain(UserEntity userEntity);

    UserEntity toDbo(User user);
}
