package spring_mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_mvc.dao.EmployeeDao;
import spring_mvc.dto.Employee;

@Service
public class EmployeeService {
	@Autowired
	public  EmployeeDao dao;
	
	public Employee	 saveEmployee(Employee employee) {
		return dao.saveEmployee(employee);
	}
	
	public Employee loginEmployee(Employee employee) {
		return dao.loginEmployee(employee);
	}
	public List<Employee> getAllEmployee() {
		return dao.getAllEmployee();
	}
	
	public Employee deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}
	
	public Employee findEmployee(int id) {
		return dao.findEmployee(id);
	}
	
	public Employee updateEmployee(Employee employee) {
		return dao.updateEmployee(employee);
	}

}
