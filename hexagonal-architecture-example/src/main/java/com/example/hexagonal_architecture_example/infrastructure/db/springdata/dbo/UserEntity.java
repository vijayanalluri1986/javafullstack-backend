package com.example.hexagonal_architecture_example.infrastructure.db.springdata.dbo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {

    @Id
    private Long id;

    private String name;

    private String address;

}
