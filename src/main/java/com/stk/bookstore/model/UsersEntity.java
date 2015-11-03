package com.stk.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UsersEntity {
	
	@Id
	@Column(columnDefinition="VARCHAR(10)")
	private String username;
	
	@Column(columnDefinition="VARCHAR(45)")
	private String password;
	
	@Column(columnDefinition="BOOLEAN")
	private Boolean enabled;

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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "UsersEntity [username=" + username + ", password=" + password
				+ ", enabled=" + enabled + "]";
	} 
	
	

}
