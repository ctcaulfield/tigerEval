package com.codd.dao;

import java.util.List;

import com.codd.model.Course;

public interface CourseDAO {
	
public int saveOrUpdate(Course course);
    
    public void delete(int courseId);
     
    public Course get(int courseId);
     
    public List<Course> list();
}
