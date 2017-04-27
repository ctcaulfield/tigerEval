package com.codd.model;

import java.sql.Date;
import java.util.List;

public class Program {
	private int program_id;
	private String name;
	private String description;
	private int department_id;
	private String outcome;
	private String reflections;
	private Date deadline;
	private int submitted;
	private int confrimed;
	private String recommendations;
	private int coordinator_id;
	private List<Course> courses;

	public Program() {

	}

	public Program(String name, String description, int department_id, String outcome, String reflections,
			Date deadline, int submitted, int confirmed, String recommendations, int coordinator_id) {
		this.name = name;
		this.description = description;
		this.department_id = department_id;
		this.outcome = outcome;
		this.reflections = reflections;
		this.deadline = deadline;
		this.submitted = submitted;
		this.confrimed = confirmed;
		this.recommendations = recommendations;
		this.coordinator_id = coordinator_id;
	}

	public int getProgram_id() {
		return program_id;
	}

	public void setProgram_id(int program_id) {
		this.program_id = program_id;
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

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getReflections() {
		return reflections;
	}

	public void setReflections(String reflections) {
		this.reflections = reflections;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public int getSubmitted() {
		return submitted;
	}

	public void setSubmitted(int submitted) {
		this.submitted = submitted;
	}

	public int getConfrimed() {
		return confrimed;
	}

	public void setConfrimed(int confrimed) {
		this.confrimed = confrimed;
	}

	public String getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}

	public int getCoordinator_id() {
		return coordinator_id;
	}

	public void setCoordinator_id(int coordinator_id) {
		this.coordinator_id = coordinator_id;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
