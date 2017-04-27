package com.codd.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.codd.dao.ProfessorDAOImpl;
import com.codd.dao.ProgramDAOImpl;
import com.codd.model.Course;
import com.codd.model.Instrument;
import com.codd.model.Program;
import com.codd.model.Section;

@Service
public class ProgramService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ProgramDAOImpl programDAO;
	
	@Autowired
	private ProfessorDAOImpl professorDAO;
	
	public List<Program> getByCoordinator(int id){
		String sql = "SELECT program_id, program.name FROM program JOIN program_course USING(program_id)" +
				" JOIN course USING(course_id) where program.coordinator_id =" + id;
		 List<Program> listProgram = jdbcTemplate.query(sql, new RowMapper<Program>() {
			 
		        @Override
		        public Program mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	Program program = new Program();
		 
		        	program.setName(rs.getString("name"));	        
		        	
		        	String sql2 = "SELECT * FROM course JOIN program_course WHERE program_id =" + rs.getInt("program_id");
		        	
		        	List<Map<String, Object>> sectionsMap = jdbcTemplate.queryForList(sql2);
		        	List<Course> courses = new ArrayList<Course>();
		        	for(Map<String,Object> m: sectionsMap){
		  
		        		Course course = new Course();
		        		course.setName((String) m.get("name"));
		        		course.setBenchmark((String) m.get("benchmark"));
		        		course.setProfessor(professorDAO.get((int)m.get("professor_id")));
		        		course.setSubmitted((int) m.get("submitted"));
		        		
		        		courses.add(course);		        		
		        	}
		        	program.setCourses(courses);
		        	return program;
		        }
		 
		    });
		 return listProgram;
	}

}
