package com.ust.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "salary", schema = "INTEGRATION")
public class Salary {
	
	@Id
    @GeneratedValue
    @Column(name="salary_id")
	private int salary_id;
	@Column(name="salary")
	private int salary;
	@Column(name="salary")
	private int empId;
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	
	
	public void salary(int salary, int empId)
	{
		this.salary = salary;
		this.empId = empId;
	}
	
	public int calculateSalary(){	
		return salary + 50000;	
	}

	public int getSalary_id() {
		return salary_id;
	}

	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}

	public Salary(int salary_id, int salary, int empId) {
		super();
		this.salary_id = salary_id;
		this.salary = salary;
		this.empId = empId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + salary;
		result = prime * result + salary_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salary other = (Salary) obj;
		if (empId != other.empId)
			return false;
		if (salary != other.salary)
			return false;
		if (salary_id != other.salary_id)
			return false;
		return true;
	}
	
	

}
