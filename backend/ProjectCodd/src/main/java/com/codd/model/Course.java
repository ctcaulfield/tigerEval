package com.codd.model;

import java.sql.Date;
import java.util.List;

public class Course {
	
	private int courseId;
	private String name;
	private String description;
	private String benchmark;
	private String startDate;
	private String endDate;
	private String deadline;
	private int submitted;
	private int confirmed;
	private int professorId;
	private int coordinatorId;
	private List<Section> sections;
	private Professor professor;
	
	public Course(){}
	
	public Course(String name, String description, String benchmark, String startDate, String endDate,
			String deadline, int submitted, int confirmed, int coordinatorId, int professorId) {
		this.name = name;
		this.description = description;
		this.benchmark = benchmark;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deadline = deadline;
		this.submitted = submitted;
		this.setConfirmed(confirmed);
		this.setCoordinatorId(coordinatorId);
		this.setProfessorId(professorId);
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
	public String getBenchmark() {
		return benchmark;
	}
	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public int getSubmitted() {
		return submitted;
	}
	public void setSubmitted(int submitted) {
		this.submitted = submitted;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public int getCoordinatorId() {
		return coordinatorId;
	}

	public void setCoordinatorId(int coordinatorId) {
		this.coordinatorId = coordinatorId;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}
	

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
