package com.codd.model;

public class College {
	
	private int collegeId;
	private String name;
	private String description;
	
	public College(){
		
	}
	
	public College(String name, String description){
		this.name = name;
		this.description = description;
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

