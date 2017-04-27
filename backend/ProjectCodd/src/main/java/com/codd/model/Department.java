package com.codd.model;

public class Department {
	
	private int departmentId, collegeId;
	private String name, description;
	
	public Department(){}
	
	public Department(int collegeId, String name, String description) {
		this.collegeId = collegeId;
		this.name = name;
		this.description = description;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
