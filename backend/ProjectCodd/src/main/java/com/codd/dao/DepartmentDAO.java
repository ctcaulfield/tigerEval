package com.codd.dao;

import java.util.List;

import com.codd.model.Department;


public interface DepartmentDAO {
	
public void saveOrUpdate(Department department);
    
    public void delete(int departmentId);
     
    public Department get(int departmentId);
     
    public List<Department> list();
}
