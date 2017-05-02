package com.codd.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Section {
	
	private int sectionId, courseId, number;
	private String startTime, endTime;
	private String dayOfWeek;
	private int submitted;
	private List<Instrument> instruments;
	
	public Section(){}
	
	
	
	public Section(int courseId, int number, String startTime, String endTime, String dayOfWeek, int submitted) {
		this.courseId = courseId;
		this.number = number;
		this.startTime = startTime;
		this.endTime = endTime;
		this.dayOfWeek = dayOfWeek;
		this.submitted = submitted;
	}



	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public int getSubmitted() {
		return submitted;
	}
	public void setSubmitted(int submitted) {
		this.submitted = submitted;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public List<Instrument> getInstruments() {
		return instruments;
	}



	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}
	
	
	
}
