package com.crud.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crud.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
