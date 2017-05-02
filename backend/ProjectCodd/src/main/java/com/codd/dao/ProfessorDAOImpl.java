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

import com.codd.model.Professor;


@Repository
public class ProfessorDAOImpl implements ProfessorDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public void saveOrUpdate(Professor professor) {
		if (professor.getId() > 0) {
	        // update
	        String sql = "UPDATE professor SET first_name=?, middle_name=?, last_name=?, "
	                    + "email=? WHERE professor_id=?";
	        jdbcTemplate.update(sql, professor.getFirstName(), professor.getMiddleName(),
	                professor.getLastName(), professor.getEmail(), professor.getId());
		}else{
			String sql = "INSERT INTO professor (first_name, middle_name, last_name, email)"
					+ "VALUES (?,?,?,?)";
			jdbcTemplate.update(sql, professor.getFirstName(), professor.getMiddleName(),
	                professor.getLastName(), professor.getEmail());
		}
	}

	@Override
	public void delete(int professorId) {
		 String sql = "DELETE FROM professor WHERE professor_id=?";
		    jdbcTemplate.update(sql, professorId);
	}

	@Override
	public Professor get(int professorId) {
		 String sql = "SELECT * FROM professor WHERE professor_id=" + professorId;
		    return jdbcTemplate.query(sql, new ResultSetExtractor<Professor>() {
		 
		        @Override
		        public Professor extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		            	Professor professor = new Professor();
		            	professor.setId(rs.getInt("professor_id"));
			            professor.setFirstName(rs.getString("first_name"));
			            professor.setMiddleName(rs.getString("middle_name"));
			            professor.setLastName(rs.getString("last_name"));
			            professor.setEmail(rs.getString("email"));
		                return professor;
		            }
		 
		            return null;
		        }
		 
		    });
	}

	@Override
	public List<Professor> list() {
		
		String sql = "SELECT * FROM professor";
	    List<Professor> listProfessor = jdbcTemplate.query(sql, new RowMapper<Professor>() {
	 
	        @Override
	        public Professor mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Professor professor = new Professor();
	 
	            professor.setId(rs.getInt("professor_id"));
	            professor.setFirstName(rs.getString("first_name"));
	            professor.setMiddleName(rs.getString("middle_name"));
	            professor.setLastName(rs.getString("last_name"));
	            professor.setEmail(rs.getString("email"));
	 
	            return professor;
	        }
	 
	    });
	 
	    return listProfessor;
	}

}
