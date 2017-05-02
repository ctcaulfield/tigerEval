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

import com.codd.model.Program;

@Repository
public class ProgramDAOImpl implements ProgramDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveOrUpdate(Program program) {
		if (program.getProgram_id() > 0) {
	        // update
	        String sql = "UPDATE college SET name=?, description=?, department_id=?, outcome=?, reflections=?, deadline=?, submitted=?, confirmed=?, recommendations=?, coordinator_id=? WHERE program_id=?";
	        jdbcTemplate.update(sql, program.getName(), program.getDescription(), program.getDepartment_id(), program.getOutcome(), program.getReflections(), program.getDeadline(), program.getSubmitted(), program.getConfrimed(), program.getRecommendations(), program.getCoordinator_id(), program.getProgram_id());
		}else{
			String sql = "INSERT INTO college (name, description, department_id, outcome, reflections, deadline, submitted, confirmed, recommendations, coordinator_id)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql, program.getName(), program.getDescription(), program.getDepartment_id(), program.getOutcome(), program.getReflections(), program.getDeadline(), program.getSubmitted(), program.getConfrimed(), program.getRecommendations(), program.getCoordinator_id());
		}
	}

	@Override
	public void delete(int program_id) {
		String sql = "DELETE FROM program WHERE program_id=?";
		jdbcTemplate.update(sql, program_id);
	}

	@Override
	public Program get(int program_id) {
		String sql = "SELECT * FROM program WHERE program_id=" + program_id;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Program>() {

			@Override
			public Program extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Program program = new Program();
					
					
					program.setProgram_id(rs.getInt("program_id"));
					program.setName(rs.getString("name"));
					program.setDescription(rs.getString("description"));
					program.setDepartment_id(rs.getInt("department_id"));
					program.setOutcome(rs.getString("outcome"));
					program.setReflections(rs.getString("reflections"));
					program.setDeadline(rs.getDate("description"));
					program.setSubmitted(rs.getInt("submitted"));
					program.setConfrimed(rs.getInt("confirmed"));
					program.setRecommendations(rs.getString("recommendations"));
					program.setCoordinator_id(rs.getInt("coordinator_id"));
					return program;
				}

				return null;
			}

		});
	}

	@Override
	public List<Program> list() {

		String sql = "SELECT * FROM program";
		List<Program> listProgram = jdbcTemplate.query(sql, new RowMapper<Program>() {

			@Override
			public Program mapRow(ResultSet rs, int rowNum) throws SQLException {
				Program program = new Program();
				
				
				program.setProgram_id(rs.getInt("program_id"));
				program.setName(rs.getString("name"));
				program.setDescription(rs.getString("description"));
				program.setDepartment_id(rs.getInt("department_id"));
				program.setOutcome(rs.getString("outcome"));
				program.setReflections(rs.getString("reflections"));
				program.setDeadline(rs.getDate("description"));
				program.setSubmitted(rs.getInt("submitted"));
				program.setConfrimed(rs.getInt("confirmed"));
				program.setRecommendations(rs.getString("recommendations"));
				program.setCoordinator_id(rs.getInt("coordinator_id"));

				return program;
			}

		});

		return listProgram;
	}

}
