package com.codd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.codd.model.Instrument;

@Repository
public class InstrumentDAOImpl implements InstrumentDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public void saveOrUpdate(Instrument instrument) {
		if (instrument.getInstrument_id() > 0) {
	        // update
	        String sql = "UPDATE instrument SET name=? WHERE instrument_id=?";
	        jdbcTemplate.update(sql, instrument.getName(), instrument.getInstrument_id());
		}else{
			String sql = "INSERT INTO instrument (name)"
					+ "VALUES (?)";
			jdbcTemplate.update(sql, instrument.getName());
		}
	}
	
	@Override
	public void delete(int instrument_id) {
		 String sql = "DELETE FROM instrument WHERE instrument_id=?";
		    jdbcTemplate.update(sql, instrument_id);
	}
	
	@Override
	public Instrument get(int instrument_id) {
		 String sql = "SELECT * FROM instrument WHERE instrument_id=" + instrument_id;
		    return jdbcTemplate.query(sql, new ResultSetExtractor<Instrument>() {
		 
		        @Override
		        public Instrument extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		            	Instrument instrument = new Instrument();
		            	instrument.setInstrument_id(rs.getInt("instrument_id"));
		            	instrument.setName(rs.getString("name"));
			            
		                return instrument;
		            }
		 
		            return null;
		        }
		 
		    });
	}
	
	@Override
	public List<Instrument> list() {
		
		String sql = "SELECT * FROM instrument";
	    List<Instrument> listInstrument = jdbcTemplate.query(sql, new RowMapper<Instrument>() {
	 
	        @Override
	        public Instrument mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Instrument instrument = new Instrument();
	 
	        	instrument.setInstrument_id(rs.getInt("instrument_id"));
	        	instrument.setName(rs.getString("name"));
	 
	            return instrument;
	        }
	 
	    });
	 
	    return listInstrument;
	}
}
