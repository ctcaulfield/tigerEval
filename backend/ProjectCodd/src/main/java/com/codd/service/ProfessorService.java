package com.codd.service;

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
	
	public Professor getProfessor(int id){
		Professor professor = professorDao.get(id);
		return professor;
	}
	
}
