package com.codd.dao;

import java.util.List;

import com.codd.model.Instrument;

public interface InstrumentDAO {
	
	public void saveOrUpdate(Instrument instrument);
    
    public void delete(int instrument_id);
     
    public Instrument get(int instrument_id);
     
    public List<Instrument> list();
}

