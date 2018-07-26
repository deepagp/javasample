package com.ust.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ust.service.EmployeeRepository;
import com.ust.vo.Employee;

public class EmployeeServiceImpl {
	
	@Autowired
	EmployeeRepository employeRepo;
	
	
	public void saveEmployee(Employee emp){
		employeRepo.save(emp);
	}

}
