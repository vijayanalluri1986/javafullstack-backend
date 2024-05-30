package com.javafullstack.springdatajpa.repository;

import com.javafullstack.springdatajpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
