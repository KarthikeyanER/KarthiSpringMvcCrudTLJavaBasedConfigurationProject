package com.gl.dao;

import java.util.List;

import com.gl.model.Employee;

public interface EmployeeDao {
	public void save(Employee employee);
	public List<Employee> findall();
	public void update(Employee employee);
	public Employee getEmpById(int empId);
	public void delete(Employee employee);

	
	public void update2(Employee employee) ;
}
