package com.codd.model;

public class Role {
	
	private int roleId;
	private String name;
	
	public Role(){}
	
	public Role(String name){
		this.name = name;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
