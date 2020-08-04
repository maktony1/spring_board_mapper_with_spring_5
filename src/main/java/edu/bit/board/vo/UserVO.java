package edu.bit.board.vo;

import org.springframework.stereotype.Repository;


@Repository
public class UserVO {
	String username;
	String password;
	char enabled;
	
	public UserVO() {
	}
	
	
	public UserVO(String username, String password, char enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
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
	public char getEnabled() {
		return enabled;
	}
	public void setEnabled(char enabled) {
		this.enabled = enabled;
	}
	
	
}