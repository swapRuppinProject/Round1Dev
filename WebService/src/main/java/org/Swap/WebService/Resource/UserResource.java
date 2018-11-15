package org.Swap.WebService.Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.json.Json;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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
	@Path("/{login}")
	public User getMessage(@BeanParam FilterBean fb,@Context UriInfo uriInfo)
	{
		User user = us.getUser(fb.getUserName(),fb.getPassword());
		return user;
	}
	
	@POST
	public Response addMessage(User u,@Context UriInfo uriInfo) throws URISyntaxException
	{
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(u.getId())).build();
		return Response.created(uri).entity(us.addUser(u)).build();
	}
	
}
