package com.test.employee.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.employee.domain.Employee;



public class EmployeeServiceImpl implements EmployeeService {

	private static Map<Long, Employee> empMap = new HashMap<Long, Employee>();

	static {

		Employee emp1 = new Employee(1, "Raja Jaganathan", "raja.jaganathan@wipro.com", "Chennai");

		Employee emp2 = new Employee(2, "Hari Kumar", "harikumarV@wipro.com", "Chennai");

		Employee emp3 = new Employee(3, "Benny John", "beennay.john@wipro.com", "Chennai");

		empMap.put(1L, emp1);

		empMap.put(2L, emp2);

		empMap.put(3L, emp3);

	}

	public List<Employee> listAllEmployees() {
		
		List<Employee> list = new ArrayList();
		
		list.addAll(empMap.values());

		System.out.println("listAllEmployees called");

		return list;

	}


	public Employee getEmployeeById(Long id) {
		

		System.out.println("getEmployeeById called =>");

		System.out.println("getEmployeeById called =>"+empMap);

		return empMap.get(id);

	}


	public Employee saveEmployee(Employee employee) {

		System.out.println("saveEmployee called");
		
		if(employee != null && !empMap.containsKey(employee.getId()))
		empMap.put(Long.valueOf(employee.getId()), employee);


		return  employee;

	}
	
	public Employee updateEmployee(Employee employee) {

		System.out.println("updateEmployee called");
		
		if(employee != null && empMap.containsKey(employee.getId()))
		empMap.put(Long.valueOf(employee.getId()), employee);

		return employee;

	}

	public void deleteEmployee(Long id) {

		System.out.println("deleteEmployee called");

		empMap.remove(id);

	}

}