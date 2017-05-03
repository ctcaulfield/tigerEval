package com.codd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.codd.dao.ProfessorDAOImpl;
import com.codd.model.Professor;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorDAOImpl professorDao;
	
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * Method used for returning the professor by id.
	 * */
	public Professor getProfessor(int id){
		Professor professor = professorDao.get(id);
		return professor;
	}
	
	
	/*
	 * Method used for returning the list of all professors.
	 * */
	public List<Professor> getAllProfessors(){
		List<Professor> list = professorDao.list();
		return list;
	}
	
}
