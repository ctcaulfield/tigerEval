package com.codd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.codd.dao.SectionDAOImpl;
import com.codd.model.Section;

@Service
public class SectionService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	private SectionDAOImpl sectionDAO;
	
	
	/*
	 * Method used for setting the average grade to the instrument of the section
	 * using sectionID and instrumentID.
	 * */
	public void setAvgGrade(int sectionId, int instrumentId, double grade){
		String sql = "UPDATE section_instrument SET avg_grade = ? WHERE section_id=? AND instrument_id=?";
		jdbcTemplate.update(sql, grade, sectionId, instrumentId);
	}
	
	/*
	 * Method used to add section.
	 * */
	public void setSection(Section section){
		sectionDAO.saveOrUpdate(section);
	}
}
