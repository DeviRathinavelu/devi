package com.devi.bags.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login {

	String username, password;

	@NotNull
	@Size(min = 5, max = 20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull
	@Size(min = 5, max = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}


