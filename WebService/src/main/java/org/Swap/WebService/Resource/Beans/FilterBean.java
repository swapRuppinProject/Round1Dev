package org.Swap.WebService.Resource.Beans;

import javax.ws.rs.QueryParam;

public class FilterBean {

	private @QueryParam("userName") String userName;
	private @QueryParam("password") String password;
	private @QueryParam("name") String name;
	private @QueryParam("id") int id;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	

}
