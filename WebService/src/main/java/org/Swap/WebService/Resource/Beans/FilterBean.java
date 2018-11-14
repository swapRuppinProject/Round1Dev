package org.Swap.WebService.Resource.Beans;

import javax.ws.rs.QueryParam;

public class FilterBean {

	private @QueryParam("name") int userName;
	private @QueryParam("id") int id;
	
	public int getUserName() {
		return userName;
	}
	public void setUserName(int userName) {
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
