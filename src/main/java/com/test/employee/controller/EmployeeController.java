package com.test.employee.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.test.employee.domain.Employee;
import com.test.employee.services.EmployeeService;
import com.test.employee.services.EmployeeServiceImpl;

@Path("/employee")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(){
		employeeService = new EmployeeServiceImpl();
	}

    @GET
	@Path( "/list")
    @Produces(MediaType.APPLICATION_JSON)
	public Iterable<Employee> list() {
		Iterable<Employee> employeeList = employeeService.listAllEmployees();
		return employeeList;
	}


    @GET
	@Path( "/show/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Employee showEmployee(@PathParam("id") String id) {
		Employee employee = employeeService.getEmployeeById(Long.valueOf(id));

		return employee;
	}

	
    @POST
    @Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Employee saveEmployee( Employee employee) {

    	System.out.println("Employee ------<");
		 
    	System.out.println("Employee ------<");
    	System.out.println("Employee ------<"+employee);
		employeeService.saveEmployee(employee);

		return employee;
	}

    @PUT
    @Path( "/update/{id}")

	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@PathParam("id") String id,  Employee employee) {
    	

    	System.out.println("Employee ------<"+id);
		Employee employeeNew = employeeService.getEmployeeById(Long.valueOf(id));

    	System.out.println("Employee ------<"+employeeNew);
		
		if(employeeNew != null){
		employeeNew.setName(employee.getName());

		employeeNew.setEmail(employee.getEmail());

		employeeNew.setLocation(employee.getLocation());
		
		
		}
		employeeService.updateEmployee(employeeNew);
		

    	System.out.println("Employee ------<"+employeeNew);
		
		return Response.status(200).entity(employeeNew).build();


	}

    
    @DELETE
    @Path( "/delete/{id}")

	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") String id) {


    	System.out.println("id ------<"+id);
    	
		employeeService.deleteEmployee(Long.valueOf(id));

		return Response.status(200).entity("OK").build();
	}

}