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

import com.codd.model.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveOrUpdate(Department department) {
		if (department.getDepartmentId() > 0) {
	        // update
	        String sql = "UPDATE department SET name=?, description=?, college_id=?, "
	                    + " WHERE department_id=?";
	        jdbcTemplate.update(sql, department.getName(), department.getDescription(),
	        		department.getCollegeId(),department.getDepartmentId());
		}else{
			String sql = "INSERT INTO department (name, description, college_id)"
					+ "VALUES (?,?,?,?)";
			jdbcTemplate.update(sql, department.getName(), department.getDescription(),
	        		department.getCollegeId());
		}

	}

	@Override
	public void delete(int departmentId) {
		String sql = "DELETE FROM department WHERE department_id=?";
	    jdbcTemplate.update(sql, departmentId);

	}

	@Override
	public Department get(int departmentId) {
		String sql = "SELECT * FROM department WHERE department_id=" + departmentId;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Department>() {
	 
	        @Override
	        public Department extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Department department = new Department();
	            	department.setDepartmentId(rs.getInt("department_id"));
	            	department.setName(rs.getString("name"));
	            	department.setDescription(rs.getString("description"));
	            	department.setCollegeId(rs.getInt("college_id"));

	                return department;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Department> list() {
		String sql = "SELECT * FROM department";
	    List<Department> listDepartment = jdbcTemplate.query(sql, new RowMapper<Department>() {
	 
	        @Override
	        public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Department department = new Department();
	        	
            	department.setDepartmentId(rs.getInt("department_id"));
            	department.setName(rs.getString("name"));
            	department.setDescription(rs.getString("description"));
            	department.setCollegeId(rs.getInt("college_id"));

                return department;
	        }
	 
	    });
	 
	    return listDepartment;
	}

}
