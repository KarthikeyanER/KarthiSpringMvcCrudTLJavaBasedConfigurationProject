package com.gl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	int id;
	String employeeName;
	String employeeAddress;
	long employeePhone;
	int employeeSalary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String employeeName, String employeeAddress, long employeePhone, int employeeSalary) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeePhone = employeePhone;
		this.employeeSalary = employeeSalary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public long getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(long employeePhone) {
		this.employeePhone = employeePhone;
	}
	public int getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", employeeAddress=" + employeeAddress
				+ ", employeePhone=" + employeePhone + ", employeeSalary=" + employeeSalary + "]";
	}
	
	
}
