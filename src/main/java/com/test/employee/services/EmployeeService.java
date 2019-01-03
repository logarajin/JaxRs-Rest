package com.test.employee.services;

import java.util.List;

import com.test.employee.domain.Employee;

public interface EmployeeService {

	List<Employee> listAllEmployees();

	Employee getEmployeeById(Long id);

	Employee saveEmployee(Employee employee);

	public void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);
}
