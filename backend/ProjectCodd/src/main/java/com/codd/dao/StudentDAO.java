package com.codd.dao;

import java.util.List;

import com.codd.model.Student;


public interface StudentDAO {
	
public void saveOrUpdate(Student student);
    
    public void delete(int studentId);
     
    public Student get(int studentId);
     
    public List<Student> list();
}
