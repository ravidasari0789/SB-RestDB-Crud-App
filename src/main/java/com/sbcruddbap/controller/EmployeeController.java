package com.sbcruddbap.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbcruddbap.model.Employee;
import com.sbcruddbap.service.EmployeeServiceimp;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeServiceimp employeeserviceimp;

	@PostMapping("/addemployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		logger.info("addEmployee()  method started");
		Employee employee = employeeserviceimp.addEmployee(emp);
		logger.info("addEmployee()  method started");
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	@PutMapping("/updateemployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		logger.info("updateEmployee()  method started");
		Employee employee = employeeserviceimp.updateEmployee(emp);
		logger.info("updateEmployee()  method ended");
		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		logger.info("deleteEmployee()  method started");
		employeeserviceimp.deleteEmployee(id);
		logger.info("deleteEmployee()  method ended");
		String message = "deleted sucessfully";
		return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
	}

	@GetMapping("/fetchemployeelist")
	public ResponseEntity<List<Employee>> findAllEmployeeDetails() {
		logger.info("getAllEmployeeDetails()  method started");
		List<Employee> list = employeeserviceimp.getEmployeeList();
		logger.info("getAllEmployeeDetails()  method ended");
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	@GetMapping("/findbyemployeeid/{id}")
	public ResponseEntity<Employee> findByEmployeid(@PathVariable("id") long id) {
		logger.info("findByEmployeid()  method started");
		Employee emp = employeeserviceimp.getEmployee(id);
		logger.info("findByEmployeid()  method started");
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);

	}
}
