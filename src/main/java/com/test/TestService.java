package com.test;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
 
/**
 * @author naveenvemulapalli
 *
 */
@Path("/testservice")
public class TestService {
 
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getTestService() {
    return "Hello World! This is coming from webservice!!";
  }
  
  

  @GET
  @Path("/{name}")
  public Response getMsg(@PathParam("name") String name) {

      String output = "Welcome   : " + name;

      return Response.status(200).entity(output).build();

  }
  
  
  @OPTIONS
  @Path("/users")
  @Produces(MediaType.APPLICATION_XML)
  public String getSupportedOperations(){
     return "<operations>GET, PUT, POST, DELETE</operations>";
  }
  
  
  

}