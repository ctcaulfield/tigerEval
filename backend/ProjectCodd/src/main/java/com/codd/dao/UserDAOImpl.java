package com.codd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.codd.model.User;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public void saveOrUpdate(User user) {
		if (user.getUser_id() > 0) {
	        // update
	        String sql = "UPDATE user SET username=?, password=?, professor_id=?, role_id=?  WHERE user_id=?";
	        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getProfessor_id(), user.getRole_id(), user.getUser_id());
		}else{
			String sql = "INSERT INTO college (username, password, professor_id, role_id)"
					+ "VALUES (?,?,?,?)";
			jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getProfessor_id(), user.getRole_id());
		}
	}
	
	@Override
	public void delete(int user_id) {
		 String sql = "DELETE FROM user WHERE user_id=?";
		    jdbcTemplate.update(sql, user_id);
	}
	

	@Override
	public User get(int user_id) {
		 String sql = "SELECT * FROM user WHERE user_id=" + user_id;
		    return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {
		 
		        @Override
		        public User extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		            	User user = new User();
		            	user.setUser_id(rs.getInt("user_id"));
		            	user.setUsername(rs.getString("username"));
		            	user.setPassword(rs.getString("password"));
		            	user.setProfessor_id(rs.getInt("professor_id"));
		            	user.setRole_id(rs.getInt("role_id"));
		                return user;
		            }
		 
		            return null;
		        }
		 
		    });
	}
	@Override
	public List<User> list() {
		
		String sql = "SELECT * FROM user";
	    List<User> listUser = jdbcTemplate.query(sql, new RowMapper<User>() {
	 
	        @Override
	        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	User user = new User();
            	user.setUser_id(rs.getInt("user_id"));
            	user.setUsername(rs.getString("username"));
            	user.setPassword(rs.getString("password"));
            	user.setProfessor_id(rs.getInt("professor_id"));
            	user.setRole_id(rs.getInt("role_id"));
                return user;
	        }
	 
	    });
	 
	    return listUser;
	}
}
