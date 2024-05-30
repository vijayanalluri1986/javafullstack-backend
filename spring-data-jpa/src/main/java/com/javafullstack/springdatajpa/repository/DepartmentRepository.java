package com.javafullstack.springdatajpa.repository;

import com.javafullstack.springdatajpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
