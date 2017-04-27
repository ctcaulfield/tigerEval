package com.codd.app;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codd.model.Course;
import com.codd.model.Section;
import com.codd.service.CourseService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/getByProfessor/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Course>> getCourseByProfessor(@PathVariable("id") int id){
		List<Course> listCourse = courseService.getCourseByProfessor(id);
		return new ResponseEntity<List<Course>>(listCourse, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getByCoordinator/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Course>> getByCoordinator(@PathVariable("id") int id){
		List<Course> listCourse = courseService.getCoordinatorCourses(id);
		return new ResponseEntity<List<Course>>(listCourse, HttpStatus.OK);
	}
	
	@RequestMapping(value="/setCourse/{id}", method=RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> setCourse(@RequestBody String course, @PathVariable("id") int id) throws JsonParseException, JsonMappingException, IOException{
		if(course!= null){
			ObjectMapper om = new ObjectMapper();
			Course newCourse = new Course();
			newCourse =  om.readValue(course, Course.class);
			courseService.setCourse(id,newCourse);
			return new ResponseEntity<>("Course added", HttpStatus.OK);
		}else{
			return new ResponseEntity<>("Course not in correct format", HttpStatus.BAD_REQUEST);
		}
	}

}
