package org.refael.WebService.Resource;



import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.refael.WebService.Model.User;
import org.refael.WebService.Service.UserService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	UserService us = new UserService();
	ObjectMapper mapper = new ObjectMapper();
	
	@GET
	public String getUsers()
	{

			String jsonInString;
			try {
				jsonInString = mapper.writeValueAsString(us.getAllUsers());
				return jsonInString;
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
return null;

		
		
	}
	
	@GET
	@Path("/echo")
	public String echo()
	{
		return "test";
	}
	
}
