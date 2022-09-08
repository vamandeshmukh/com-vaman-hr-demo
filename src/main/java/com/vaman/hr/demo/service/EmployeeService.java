package com.vaman.hr.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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

	public void karthikDeleteEmp(int employeeId) {

		Employee emp1 = null;
		Stream<Employee> myEmp = empList.stream();
		int i;
		
		empList.stream().filter(emp -> 
			 emp.getEmployeeId() == employeeId );

//	emp1=empList.get(i);

//	String name = emp1.getFirstName();empList.remove(emp1);return name+"'s Employee file removed from the Database";
	}}

	public Employee viewEmployeeById(int employeeId) {
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
		// your code
		return null;
	}

	public Employee deleteEmployeeById(int employeeId) {
		// your code
		return null;
	}
}
