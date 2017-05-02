package com.codd.dao;

import java.util.List;

import com.codd.model.Role;


public interface RoleDAO {
	
public void saveOrUpdate(Role role);
    
    public void delete(int roleId);
     
    public Role get(int roleId);
     
    public List<Role> list();
}
