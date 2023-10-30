package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dao.EmployeeDao;
import com.gl.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDao eDao;

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		eDao.save(employee);
		
	}

	@Override
	public List<Employee> findall() {
		// TODO Auto-generated method stub
		return eDao.findall();
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		eDao.update(employee);
	}

	@Override
	public Employee getEmpById(int empId) {
		// TODO Auto-generated method stub
		return eDao.getEmpById(empId);
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		eDao.delete(employee);
	}

}
