package com.test.employee.domain;

import java.io.Serializable;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "employee")
public class Employee implements Serializable {
	
		
	private int id;
	private String name;
	private String email;
	private String location;
	
	public Employee() {
	
	}

	public Employee(int id, String name, String email, String location) {
	
		this.id = id;
		this.name = name;
		this.email = email;
		this.location = location;
	}

		
	

	public int getId() {
		return id;
	}

	 @XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	 @XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	 @XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	 @XmlElement
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", name=" + name + ", email=" + email + ", location=" + location + "]";
	}
	
	
}