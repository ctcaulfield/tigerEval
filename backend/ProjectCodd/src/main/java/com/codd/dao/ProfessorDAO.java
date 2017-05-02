package com.codd.dao;

import java.util.List;

import com.codd.model.Professor;

public interface ProfessorDAO {
	
	public void saveOrUpdate(Professor professor);
    
    public void delete(int professorId);
     
    public Professor get(int professorId);
     
    public List<Professor> list();
}
