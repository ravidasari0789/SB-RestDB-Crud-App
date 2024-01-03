package com.sbcruddbap.service;

import java.util.List;

import com.sbcruddbap.model.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee emp);

	public Employee updateEmployee(Employee emp);

	public void deleteEmployee(long id);

	public List<Employee> getEmployeeList();

	public Employee getEmployee(long id);
}
