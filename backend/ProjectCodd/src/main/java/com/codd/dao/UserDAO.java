package com.codd.dao;

import java.util.List;

import com.codd.model.User;

public interface UserDAO {
	
	public void saveOrUpdate(User user);
    
    public void delete(int user_id);
     
    public User get(int user_id);
     
    public List<User> list();
}
