package com.crud.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crud.model.Employee;
import com.crud.crud.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

  @Autowired
  EmployeeRepository employeeRepository;

  @GetMapping("/employee")
  public ResponseEntity<List<Employee>> getAllEmployees() {
    try {
      List<Employee> employees = new ArrayList<Employee>();
      employeeRepository.findAll().forEach(employees::add);
      
      if (employees.isEmpty()) 
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);    	

      return new ResponseEntity<>(employees, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/employee/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
    Optional<Employee> employeeData = employeeRepository.findById(id);

    if (employeeData.isPresent()) {
      return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/employee")
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    try {
      Employee _employee = employeeRepository
          .save(new Employee(employee.getFullName(), employee.getEmpCode(), employee.getMobile()));
      return new ResponseEntity<>(_employee, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/employee/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
    Optional<Employee> employeeData = employeeRepository.findById(id);

    if (employeeData.isPresent()) {
      Employee _employee = employeeData.get();
      _employee.setFullName(employee.getFullName());
      _employee.setEmpCode(employee.getEmpCode());
      _employee.setMobile(employee.getMobile());
      return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/employee/{id}")
  public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
    try {
      employeeRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  } 
  
}
