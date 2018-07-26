package com.ust.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.vo.Salary;

public interface SalaryRepository  extends JpaRepository<Salary, Long> {

}
