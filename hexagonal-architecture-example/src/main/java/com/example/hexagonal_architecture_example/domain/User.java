package com.example.hexagonal_architecture_example.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

  private Long id;

  private String name;

  private String address;
}
