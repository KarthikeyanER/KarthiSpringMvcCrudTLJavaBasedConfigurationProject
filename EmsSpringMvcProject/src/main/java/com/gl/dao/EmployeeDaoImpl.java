package com.gl.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.gl.model.Employee;
@EnableTransactionManagement
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	SessionFactory sf;
	Session session;

	
	public EmployeeDaoImpl(SessionFactory sf) {
		super();
		this.sf = sf;
		this.session=sf.openSession();
	}
	List<Employee> list=new ArrayList<Employee>();
	@Override
	@Transactional
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		//list.add(employee);
		Transaction tx=session.beginTransaction();
		session.save(employee);
		tx.commit();
		
	}
	@Override
	@Transactional
	public List<Employee> findall() {
		// TODO Auto-generated method stub
	
		
		
		return session.createQuery("from Employee").list();
	}
	
	@Override
	@Transactional
	public Employee getEmpById(int empId) {
		// TODO Auto-generated method stub
		
		Employee e=session.get(Employee.class,empId);
		return e;
	}
	@Override
	@Transactional
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		Transaction tx=session.beginTransaction();
		session.delete(employee);
		tx.commit();
	}
	

	
	
	
	@Override
	@Transactional
	public void update(Employee employee) {
		// TODO Auto-generated method stub
//		int id=employee.getId();
//		Employee e=session.get(Employee.class,id);
//		e.setEmployeeName(employee.getEmployeeName());
//		e.setEmployeeAddress(employee.getEmployeeAddress());
//		e.setEmployeePhone(employee.getEmployeePhone());
//		e.setEmployeeSalary(employee.getEmployeeSalary());
	session.merge(employee);		
		
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	@Transactional
	public void update2(Employee employee) {
		// TODO Auto-generated method stub
		Transaction tx=session.beginTransaction();
		session.createQuery("update Employee set employeeName='"+employee
				.getEmployeeName()+"',employeeAddress='"+employee
				.getEmployeeAddress()+"',employeePhone="+employee
				.getEmployeePhone()+",employeeSalary="+employee
				.getEmployeeSalary()+" where id="+employee
				.getId()).executeUpdate();
		//session.save(employee);
		
		tx.commit();
		
		//This update2 method is working but updates get reflected in database but not in browser .
		//update will take place in browser by manually(we need to stop and start server.)
	}
}
