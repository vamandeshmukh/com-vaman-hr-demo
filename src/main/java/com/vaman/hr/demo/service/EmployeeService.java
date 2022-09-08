package com.vaman.hr.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaman.hr.demo.model.Employee;

public class EmployeeService {

	private final Logger logger = LogManager.getLogger(this.getClass());
	private List<Employee> empList = new ArrayList<>();

	public Employee addEmployee(Employee employee) {
		logger.info(employee.getEmployeeId());
		if (empList.contains(employee)) {
			logger.error("Employee with eid " + employee.getEmployeeId() + " already exists.");
			return null;
		} else {
			empList.add(employee);
			return null;
		}
	}

	public List<Employee> viewAllEmployees() {
		if (empList.isEmpty())
			logger.warn("No employees exist.");
		return empList;

	}
}
