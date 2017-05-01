package com.codd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.codd.model.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveOrUpdate(Course course) {
		Date startDate = null;
		Date endDate = null;
		Date deadline = null;
		startDate = java.sql.Date.valueOf(course.getStartDate());
		endDate = java.sql.Date.valueOf(course.getEndDate());
		endDate = java.sql.Date.valueOf(course.getDeadline());
		 
		if (course.getCourseId() > 0) {
	        // update
	        String sql = "UPDATE course SET name=?, description=?,  "
	                    + "benchmark=?, term=?,start_date=?,end_date=?,deadline=?,submitted=?,"
	                    + "confirmed=?, coordinator_id=?, professor_id=? WHERE course_id=?";
	        jdbcTemplate.update(sql, course.getName(), course.getDescription(),
	                course.getBenchmark(), course.getTerm(), startDate,
	                endDate, deadline, course.getSubmitted(), course.getConfirmed(),
	                course.getCoordinatorId(), course.getProfessorId(), course.getCourseId());
	        return course.getCourseId();
		}else{
			String sql = "INSERT INTO course (name, description, benchmark, start_date,end_date,"
					+ "deadline,submitted, confirmed, coordinator_id, professor_id, term) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			KeyHolder holder = new GeneratedKeyHolder();

			jdbcTemplate.update(new PreparedStatementCreator() {           

			                @Override
			                public PreparedStatement createPreparedStatement(Connection connection)
			                        throws SQLException {
			                    PreparedStatement ps = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			                    ps.setString(1, course.getName());
			                    ps.setString(2, course.getDescription());
			                    ps.setString(3, course.getBenchmark());
			                    ps.setDate(4, java.sql.Date.valueOf(course.getStartDate()));
			                    ps.setDate(5, java.sql.Date.valueOf(course.getEndDate()));
			                    ps.setDate(6, java.sql.Date.valueOf(course.getDeadline()));
			                    ps.setInt(7, course.getSubmitted());
			                    ps.setInt(8, course.getConfirmed());
			                    ps.setInt(9, course.getCoordinatorId());
			                    ps.setInt(10, course.getProfessorId());
			                    ps.setString(10, course.getTerm());
			                    
			                    return ps;
			                }
			            }, holder);

			Long newCourseId = holder.getKey().longValue();
			return newCourseId.intValue();
		}

	}

	@Override
	public void delete(int courseId) {
		String sql = "DELETE FROM course WHERE course_id=?";
	    jdbcTemplate.update(sql, courseId);

	}

	@Override
	public Course get(int courseId) {
		String sql = "SELECT * FROM course WHERE course_id=" + courseId;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Course>() {
	 
	        @Override
	        public Course extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Course course = new Course();
	            	course.setCourseId(rs.getInt("course_id"));
	            	course.setName(rs.getString("name"));
	            	course.setDescription(rs.getString("description"));
	            	course.setBenchmark(rs.getString("benchmark"));
	            	course.setStartDate(rs.getDate("start_date").toString());
	            	course.setEndDate(rs.getDate("end_date").toString());
	            	course.setDeadline(rs.getDate("deadline").toString());
	            	course.setSubmitted(rs.getInt("submitted"));
	            	course.setConfirmed(rs.getInt("confirmed"));
	            	course.setCoordinatorId(rs.getInt("coordinator_id"));
	            	course.setProfessorId(rs.getInt("professor_id"));
	                return course;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Course> list() {
		String sql = "SELECT * FROM course";
	    List<Course> listCourse = jdbcTemplate.query(sql, new RowMapper<Course>() {
	 
	        @Override
	        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Course course = new Course();
	 
	            course.setCourseId(rs.getInt("course_id"));
            	course.setName(rs.getString("name"));
            	course.setDescription(rs.getString("description"));
            	course.setBenchmark(rs.getString("benchmark"));
            	course.setStartDate(rs.getDate("start_date").toString());
            	course.setEndDate(rs.getDate("end_date").toString());
            	course.setDeadline(rs.getDate("deadline").toString());
            	course.setSubmitted(rs.getInt("submitted"));
            	course.setConfirmed(rs.getInt("confirmed"));
            	course.setCoordinatorId(rs.getInt("coordinator_id"));
            	course.setProfessorId(rs.getInt("professor_id"));
	 
	            return course;
	        }
	 
	    });
	 
	    return listCourse;
	}

}
