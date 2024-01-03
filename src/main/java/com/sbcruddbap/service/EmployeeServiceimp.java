package com.sbcruddbap.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbcruddbap.dao.EmployeeDao;
import com.sbcruddbap.model.Employee;

@Service
public class EmployeeServiceimp implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceimp.class);

	@Autowired
	private EmployeeDao employeedao;

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		logger.info("addEmployee() method started");
		Employee employee = employeedao.save(emp);
		logger.info("addEmployee() method ended");
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		logger.info("updateEmployee() method started");
		Employee empployee = employeedao.save(emp);
		logger.info("updateEmployee() method ended");
		return empployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		logger.info("deleteEmployee() method started");
		employeedao.deleteById(id);

		logger.info("deleteEmployee() method ended");
	}

	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		logger.info("getEmployeeList() method started");
		List<Employee> list = employeedao.findAll();
		logger.info("getEmployeeList() method ended");
		return list;
	}

	@Override
	public Employee getEmployee(long id) {
		// TODO Auto-generated method stub
		logger.info("getEmployee() method started");
		Employee empid = employeedao.findById(id).get();
		logger.info("getEmployee() method ended");
		return empid;
	}

}
