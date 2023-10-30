package com.gl.service;

import java.util.List;

import com.gl.model.Employee;

public interface EmployeeService {
	public void save(Employee employee);
	public List<Employee> findall();
	public void update(Employee employee);
	public Employee getEmpById(int empId);
	public void delete(Employee employee);
}
