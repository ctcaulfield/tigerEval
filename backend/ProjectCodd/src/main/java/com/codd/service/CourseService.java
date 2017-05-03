package com.codd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.codd.dao.CourseDAOImpl;
import com.codd.dao.ProfessorDAOImpl;
import com.codd.model.Course;
import com.codd.model.Instrument;
import com.codd.model.Professor;
import com.codd.model.Section;

@Service
public class CourseService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	private CourseDAOImpl courseDAO;
	
	@Autowired
	private ProfessorDAOImpl professorDAO;
	
	/*
	 * Method used for retrieving the list of courses by the professor's id.
	 * Each course contains list of sections, each section contains list of instruments.
	 * */
	public List<Course> getCourseByProfessor(int id){
		String sql = "SELECT name, benchmark, submitted FROM course WHERE professor_id=" + id;
	    List<Course> listCourse = jdbcTemplate.query(sql, new RowMapper<Course>() {
	 
	        @Override
	        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Course course = new Course();
	 
	        	course.setName(rs.getString("name"));
	        	course.setSubmitted(rs.getInt("submitted"));
	        	course.setBenchmark(rs.getString("benchmark"));
	        	
	        	String sql2 = "SELECT * FROM section WHERE course_id =" + id;
	        	List<Map<String, Object>> sectionsMap = jdbcTemplate.queryForList(sql2);
	        	List<Section> sections = new ArrayList<Section>();
	        	for(Map<String,Object> m: sectionsMap){
	        		Section section = new Section();
	        		section.setNumber((int) m.get("number"));
	        		String sql3 = "SELECT name, avg_grade FROM  section JOIN section_instrument USING(section_id)"
	        				+ " JOIN instrument USING(instrument_id) WHERE section_id=" + m.get("section_id");
	        		List<Instrument> instrumentList = new ArrayList<Instrument>();
	        		List<Map<String,Object>> instrumentsMap = jdbcTemplate.queryForList(sql3);
	        		for(Map<String,Object> instr: instrumentsMap){
	        			Instrument instrument = new Instrument();
	        			instrument.setName((String) instr.get("name"));
	        			instrument.setAvgGrade((double) instr.get("avg_grade"));
	        			
	        			instrumentList.add(instrument);
	        		}
	        		section.setInstruments(instrumentList);
	        		sections.add(section);
	        		
	        	}
	        
	        	course.setSections(sections);
	        	
	            return course;
	        }
	 
	    });
	 
	    return listCourse;
		
	}
	
	/*
	 * Method used to set the outcome of the course.
	 * Returns the average grade for the course based on the average grade of the sections.
	 * */
	public void setOutcome(int id){
		String sql = "SELECT AVG(avg_grade) FROM section_instrument JOIN section USING(section_id)"
				+ " JOIN course USING(course_id) WHERE course_id=?";
		double value = jdbcTemplate.queryForObject(sql, new Object[] {id}, Double.class);
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		String sql2 = "UPDATE course SET outcome =? WHERE course_id=?";
		jdbcTemplate.update(sql2, bd, id);
	}
	
	/*
	 * Method used for inserting the course in the program using program id.
	 * */
	public void setCourse(int id, Course course){
		int courseId = courseDAO.saveOrUpdate(course);
		
		String sql = "INSERT INTO  program_course(program_id, course_id) VALUES(?, ?)";

		jdbcTemplate.update(sql, id, courseId);
	}
	
	/*
	 * Method used for returning the courses belonging to a coordinator by coordinator id.
	 * */
	public List<Course> getCoordinatorCourses(int id){
		String sql = "SELECT course_id, professor_id, name, benchmark, submitted FROM course WHERE coordinator_id="+id;
	    List<Course> listCourse = jdbcTemplate.query(sql, new RowMapper<Course>() {
	 
	        @Override
	        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Course course = new Course();
	        	course.setCourseId(rs.getInt("course_id"));
	        	course.setName(rs.getString("name"));
	        	course.setSubmitted(rs.getInt("submitted"));
	        	course.setBenchmark(rs.getString("benchmark"));
	        	
	        	String sql2 = "SELECT * FROM section WHERE course_id =" + course.getCourseId();
	        	
	        	List<Map<String, Object>> sectionsMap = jdbcTemplate.queryForList(sql2);
	        	List<Section> sections = new ArrayList<Section>();
	        	for(Map<String,Object> m: sectionsMap){
	  
	        		Section section = new Section();
	        		section.setSectionId((int) m.get("section_id"));
	        		section.setNumber((int) m.get("number"));
	        		String sql3 = "SELECT name, avg_grade FROM  section JOIN section_instrument USING(section_id)"
	        				+ " JOIN instrument USING(instrument_id) WHERE section_id=" + section.getSectionId();
	        		List<Instrument> instrumentList = new ArrayList<Instrument>();
	        		List<Map<String,Object>> instrumentsMap = jdbcTemplate.queryForList(sql3);
	        		for(Map<String,Object> instr: instrumentsMap){
	        			Instrument instrument = new Instrument();
	        			instrument.setInstrument_id((int) instr.get("instrument_id"));
	        			instrument.setName((String) instr.get("name"));
	        			instrument.setAvgGrade((double) instr.get("avg_grade"));
	        			instrumentList.add(instrument);
	        		}
	        		section.setInstruments(instrumentList);
	        		sections.add(section);
	        		
	        	}
	        	course.setProfessor(professorDAO.get(rs.getInt("professor_id")));
	        
	        	course.setSections(sections);
	        	
	            return course;
	        }
	 
	    });
	 
	    return listCourse;
	}

}
