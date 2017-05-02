package com.codd.dao;

import java.util.List;

import com.codd.model.Program;

public interface ProgramDAO {
	
	public void saveOrUpdate(Program program);
    
    public void delete(int program_id);
     
    public Program get(int program_id);
     
    public List<Program> list();
}
