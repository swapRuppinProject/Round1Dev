package org.Swap.WebService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name="users")
@Table(name="users")
@XmlRootElement
public class User extends BaseEntity{
	
	@Column(name="personal_id")
	private int personalID;
	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String password;
	
	
	
	
	public User() {
		super();
	}

	public User(int personalID, String userName, String password) {
		super();
		this.personalID = personalID;
		this.userName = userName;
		this.password = password;
	}

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

	public int getPersonalID() {
		return personalID;
	}

	public void setPersonalID(int personalID) {
		this.personalID = personalID;
	}
	
}
