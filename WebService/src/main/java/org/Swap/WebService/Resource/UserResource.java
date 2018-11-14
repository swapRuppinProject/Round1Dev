package org.Swap.WebService.Resource;

import java.util.List;

import javax.json.Json;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.Swap.WebService.Model.User;
import org.Swap.WebService.Resource.Beans.FilterBean;
import org.Swap.WebService.Service.UserService;


@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	UserService us = new UserService();
	
	@GET
	public List<User> getUsers(@BeanParam FilterBean fb)
	{
		if(fb.getId() > 0)
		{
			
		}
		return us.getAllUsers();
	}
	
	@GET
	@Path("/echo")
	public String echo()
	{
		return "test";
	}
	
}
