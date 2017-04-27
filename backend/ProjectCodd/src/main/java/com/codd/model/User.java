package com.codd.model;

public class User {
	private int user_id;
	private String username;
	private String password;
	private int professor_id;
	private int role_id;
	
	public User(){
		
	}
	
	public User(String username, String password, int professor_id, int role_id){
		this.username = username;
		this.password = password;
		this.professor_id = professor_id;
		this.role_id = role_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public int getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(int professor_id) {
		this.professor_id = professor_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
}
