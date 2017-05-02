package com.codd.app;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codd.model.Section;
import com.codd.service.SectionService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/section")
public class SectionController {
	
	@Autowired
	private SectionService sectionService;
	
	@RequestMapping(value="/setGrade", method=RequestMethod.PUT)
	public ResponseEntity<?> setGrade(@RequestParam int sectionId, @RequestParam int instrumentId, @RequestParam double avgGrade){
		sectionService.setAvgGrade(sectionId, instrumentId, avgGrade);
		return new ResponseEntity<>("Section grade updated", HttpStatus.OK);
	}
	
	@RequestMapping(value="/setSection", method=RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> setSection(@RequestBody String section) throws JsonParseException, JsonMappingException, IOException{
		if(section!= null){
			ObjectMapper om = new ObjectMapper();
			Section newSection = new Section();
			newSection =  om.readValue(section, Section.class);
			sectionService.setSection(newSection);
			return new ResponseEntity<>("Section added", HttpStatus.OK);
		}else{
			return new ResponseEntity<>("Section not in correct format", HttpStatus.BAD_REQUEST);
		}
	}
}
