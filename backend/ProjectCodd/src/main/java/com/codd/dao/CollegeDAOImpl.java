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

import com.codd.model.College;

@Repository
public class CollegeDAOImpl implements CollegeDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public void saveOrUpdate(College college) {
		if (college.getCollegeId() > 0) {
	        // update
	        String sql = "UPDATE college SET name=?, description=? WHERE college_id=?";
	        jdbcTemplate.update(sql, college.getName(), college.getDescription(), college.getCollegeId());
		}else{
			String sql = "INSERT INTO college (name, description)"
					+ "VALUES (?,?)";
			jdbcTemplate.update(sql, college.getName(), college.getDescription());
		}
	}
	
	@Override
	public void delete(int collegeId) {
		 String sql = "DELETE FROM college WHERE college_id=?";
		    jdbcTemplate.update(sql, collegeId);
	}
	
	@Override
	public College get(int collegeId) {
		String sql = "SELECT * FROM department WHERE department_id=" + collegeId;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<College>() {
	 
	        @Override
	        public College extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	College college = new College();
	            	college.setCollegeId(rs.getInt("college_id"));
	            	college.setName(rs.getString("name"));
	            	college.setDescription(rs.getString("description"));
	            	college.setCollegeId(rs.getInt("college_id"));

	                return college;
	            }
	 
	            return null;
	        }
	 
	    });
	}


	@Override
	public List<College> list() {
		String sql = "SELECT * FROM college";
	    List<College> listCollege = jdbcTemplate.query(sql, new RowMapper<College>() {
	 
	        @Override
	        public College mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	College college = new College();
            	college.setCollegeId(rs.getInt("college_id"));
            	college.setName(rs.getString("name"));
            	college.setDescription(rs.getString("description"));
            	college.setCollegeId(rs.getInt("college_id"));

                return college;
	        }
	 
	    });
	 
	    return listCollege;
	}
}
