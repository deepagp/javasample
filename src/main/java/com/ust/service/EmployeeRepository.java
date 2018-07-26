package com.ust.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.vo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
