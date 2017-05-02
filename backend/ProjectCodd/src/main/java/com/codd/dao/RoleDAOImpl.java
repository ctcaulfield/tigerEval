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

import com.codd.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void saveOrUpdate(Role role) {
		if (role.getRoleId() > 0) {
	        // update
	        String sql = "UPDATE role SET name=?, WHERE role_id=?";
	        jdbcTemplate.update(sql, role.getName(), role.getRoleId());
		}else{
			String sql = "INSERT INTO role (name)"
					+ "VALUES (?,?)";
			jdbcTemplate.update(sql, role.getName());
		}

	}

	@Override
	public void delete(int roleId) {
		String sql = "DELETE FROM role WHERE role_id=?";
	    jdbcTemplate.update(sql, roleId);

	}

	@Override
	public Role get(int roleId) {
		String sql = "SELECT * FROM role WHERE role_id=" + roleId;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Role>() {
	 
	        @Override
	        public Role extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Role role = new Role();
	            	role.setRoleId(rs.getInt("role_id"));
	            	role.setName(rs.getString("name"));            	

	                return role;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Role> list() {
		String sql = "SELECT * FROM college";
	    List<Role> listRole = jdbcTemplate.query(sql, new RowMapper<Role>() {
	 
	        @Override
	        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Role role = new Role();
            	role.setRoleId(rs.getInt("role_id"));
            	role.setName(rs.getString("name"));            	

                return role;
	        }
	 
	    });
	 
	    return listRole;
	}

}
