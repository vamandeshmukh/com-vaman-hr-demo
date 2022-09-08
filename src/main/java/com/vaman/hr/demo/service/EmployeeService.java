package com.vaman.hr.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaman.hr.demo.exception.EmployeeNotFoundException;
import com.vaman.hr.demo.model.Employee;

public class EmployeeService {

	private final Logger logger = LogManager.getLogger(this.getClass());
	private List<Employee> empList = new ArrayList<>();

	public List<Employee> viewAllEmployees() {
		if (empList.isEmpty())
			logger.warn("No employees exist.");
		return empList;
	}

//	public void karthikDeleteEmp(int employeeId) {
//
//		Employee emp1 = null;
//		Stream<Employee> myEmp = empList.stream();
//		int i;
//
//		List<Employee> filteredList = empList.stream().filter(emp -> emp.getEmployeeId() == employeeId)
//				.collect(Collectors.toList());
//
////	emp1=empList.get(i);
//
////	String name = emp1.getFirstName();empList.remove(emp1);return name+"'s Employee file removed from the Database";
//	}

	public Employee viewEmployeeById(int employeeId) { // 101
		Optional<Employee> empOptional = empList.stream().filter(e -> e.getEmployeeId() == employeeId).findAny();
		if (empOptional.isPresent())
			return empOptional.get();
		throw new EmployeeNotFoundException("Employee with eid " + employeeId + " does not exist.");
	}

	public Employee addEmployee(Employee employee) {
		if (empList.contains(employee)) {
			logger.error("Employee with eid " + employee.getEmployeeId() + " already exists.");
			return null;
		} else {
			empList.add(employee);
			System.out.println("Employee added successfully.");
			return null;
		}
	}

	public Employee updateEmployee(Employee employee) {
		empList.set(empList.indexOf(this.viewEmployeeById(employee.getEmployeeId())), employee);
		return employee;
	}

	public Employee deleteEmployeeById(int employeeId) {
		Employee emp = this.viewEmployeeById(employeeId);
		empList.remove(emp);
		return emp;
	}
}
