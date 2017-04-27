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

import com.codd.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveOrUpdate(Student student) {
		if (student.getStudentId() > 0) {
	        // update
	        String sql = "UPDATE student SET first_name=?, middle_name=?, last_name=?, email=? current_year=? WHERE student_id=?";
	        jdbcTemplate.update(sql, student.getFirstName(), student.getMiddleName(), student.getLastName(), student.getEmail(),
	        		student.getCurrentYear(), student.getStudentId());
		}else{
			String sql = "INSERT INTO student (first_name, middle_name, last_name, email, current_year)"
					+ "VALUES (?,?)";
			jdbcTemplate.update(sql, student.getFirstName(), student.getMiddleName(), student.getLastName(), student.getEmail(),
	        		student.getCurrentYear());
		}

	}

	@Override
	public void delete(int studentId) {
		String sql = "DELETE FROM student WHERE student_id=?";
	    jdbcTemplate.update(sql, studentId);
	}

	@Override
	public Student get(int studentId) {
		String sql = "SELECT * FROM student WHERE student_Id=" + studentId;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Student>() {
	 
	        @Override
	        public Student extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Student student = new Student();
	            	student.setStudentId(rs.getInt("student_Id"));
	            	student.setFirstName(rs.getString("first_name"));  
	            	student.setMiddleName(rs.getString("middle_name")); 
	            	student.setLastName(rs.getString("last_name")); 

	                return student;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Student> list() {
		String sql = "SELECT * FROM student";
	    List<Student> listStudent = jdbcTemplate.query(sql, new RowMapper<Student>() {
	 
	        @Override
	        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Student student = new Student();
            	student.setStudentId(rs.getInt("student_Id"));
            	student.setFirstName(rs.getString("first_name"));  
            	student.setMiddleName(rs.getString("middle_name")); 
            	student.setLastName(rs.getString("last_name")); 

                return student;
	        }
	 
	    });
	 
	    return listStudent;
	}

}
