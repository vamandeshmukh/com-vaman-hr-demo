package com.vaman.hr.demo.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.vaman.hr.demo.model.Employee;

public class EmployeeDao {

	private final Logger logger = LogManager.getLogger(this.getClass());
	private Gson gson = new Gson();

	public Employee addEmp(Employee employee) {
		gson.toJson(employee);
		return employee;
	}

}
