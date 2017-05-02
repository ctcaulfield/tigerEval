package com.codd.dao;

import java.util.List;

import com.codd.model.College;

public interface CollegeDAO {
	
	public void saveOrUpdate(College college);
    
    public void delete(int collegeId);
     
    public College get(int collegeId);
     
    public List<College> list();
}
