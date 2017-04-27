package com.codd.dao;

import java.util.List;

import com.codd.model.Section;

public interface SectionDAO {
	
public void saveOrUpdate(Section section);
    
    public void delete(int sectionId);
     
    public Section get(int sectionId);
     
    public List<Section> list();
}
