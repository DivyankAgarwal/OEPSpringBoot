package com.vwits.OEP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="oepusers")
public class Users {
	
	@Id
	@Column(name="empid")
	int empid;
	@Column(name="Name")
	String name;
	@Column(name="Username")
	String username;
	@Column(name="Password")
	String password;
	@Column(name="Role")
	String role;
	@Column(name="Enabled")
	private String enabled;
	
	public Users() {
		
	}
	
	public Users(int empid, String name, String username, String password, String role, String enabled) {
		super();
		this.empid = empid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}
	
	

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String isEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [empid=" + empid + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", role=" + role + ", enabled=" + enabled + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (empid != other.empid)
			return false;
		return true;
	}
	


	
	
	

}
