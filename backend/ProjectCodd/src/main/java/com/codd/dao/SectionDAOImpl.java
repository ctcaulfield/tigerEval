package com.codd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.codd.model.Section;

@Repository
public class SectionDAOImpl implements SectionDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveOrUpdate(Section section) {
		if (section.getSectionId() > 0) {
	        String sql = "UPDATE section SET course_id=?, number=?, start_time=?, "
	                    + "end_time=?, day_of_week=?, submitted=? WHERE professor_id=?";
	        
			jdbcTemplate.update(sql, section.getCourseId(), Time.valueOf(section.getStartTime()),
	        		Time.valueOf(section.getEndTime()), section.getDayOfWeek(), section.getSubmitted(), section.getSectionId());
		}else{
			String sql = "INSERT INTO section (course_id, number, start_time, end_time,day_of_week,submitted )"
					+ "VALUES (?,?,?,?,?,?)";
			jdbcTemplate.update(sql, section.getCourseId(), section.getNumber(),Time.valueOf(section.getStartTime()),
	        		Time.valueOf(section.getEndTime()), section.getDayOfWeek(), section.getSubmitted());
		}

	}

	@Override
	public void delete(int sectionId) {
		 String sql = "DELETE FROM section WHERE section_id=?";
		    jdbcTemplate.update(sql, sectionId);

	}

	@Override
	public Section get(int sectionId) {
		 String sql = "SELECT * FROM section WHERE section_id=" + sectionId;
		    return jdbcTemplate.query(sql, new ResultSetExtractor<Section>() {
		 
		        @Override
		        public Section extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		            	Section section = new Section();
		            	section.setSectionId(rs.getInt("section_id"));
		            	section.setCourseId(rs.getInt("course_id"));
		            	section.setStartTime(rs.getTime("start_time").toString());
		            	section.setEndTime(rs.getTime("end_time").toString());
		            	section.setDayOfWeek(rs.getString("day_of_week"));
		            	section.setSubmitted(rs.getInt("submitted"));
		                return section;
		            }
		 
		            return null;
		        }
		 
		    });
	}

	@Override
	public List<Section> list() {
		String sql = "SELECT * FROM section";
	    List<Section> listSection = jdbcTemplate.query(sql, new RowMapper<Section>() {
	 
	        @Override
	        public Section mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Section section = new Section();
	 
	        	section.setSectionId(rs.getInt("section_id"));
            	section.setCourseId(rs.getInt("course_id"));
            	section.setStartTime(rs.getTime("start_time").toString());
            	section.setEndTime(rs.getTime("end_time").toString());
            	section.setDayOfWeek(rs.getString("day_of_week"));
            	section.setSubmitted(rs.getInt("submitted"));
                return section;
	 
	        }
	 
	    });
	 
	    return listSection;
	}

}
