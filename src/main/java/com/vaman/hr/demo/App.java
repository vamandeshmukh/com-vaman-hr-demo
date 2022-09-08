package com.vaman.hr.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Vaman Deshmukh
 * 
 *         HR management app for EYGDS trainees Aug 2022
 *
 */

public class App {

	private static final Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		logger.info("Start");
		System.out.println("Welcome to HR management application:\n");
		Hrm.selectOption();
		logger.info("End");
	}
}
