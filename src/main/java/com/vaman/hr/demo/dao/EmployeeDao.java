package com.vaman.hr.demo.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vaman.hr.demo.model.Employee;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class EmployeeDao {
	
//	jdbc code to perform CRUD op on DB 

//	private Gson gson = new Gson();
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private List<Employee> empList = new ArrayList<>();
	private File file = new File("empData.json");
	private FileWriter writer;
	private FileReader reader;

	private void createFile() {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public List<Employee> readDataFromFile() {
		this.createFile();
		try {
			reader = new FileReader(file);
			Type listType = new TypeToken<ArrayList<Employee>>() {
			}.getType();
			empList = gson.fromJson(reader, listType);
//			empList = gson.fromJson(reader, List<Employee>.class);
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (null == empList)
			empList = new ArrayList<>();
		return empList;
	}

	public void writeDataToFile(List<Employee> empList) {
		this.createFile();
		try {
			writer = new FileWriter(file);
			gson.toJson(empList, writer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.readDataFromFile();
	}
}


