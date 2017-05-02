package com.codd.model;

public class Instrument {
	private int instrument_id;
	private String name;
	private double avgGrade;
	
	public Instrument(){
		
	}
	
	public Instrument(String name){
		this.name = name;
	}

	public int getInstrument_id() {
		return instrument_id;
	}

	public void setInstrument_id(int instrument_id) {
		this.instrument_id = instrument_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}
	
}
