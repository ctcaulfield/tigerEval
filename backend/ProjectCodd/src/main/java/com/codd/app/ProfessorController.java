package com.codd.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codd.model.Professor;
import com.codd.service.ProfessorService;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping(value="/getProfessor/{id}", method=RequestMethod.GET)
	public ResponseEntity<Professor> getProfessor(@PathVariable("id") int id){
		return new ResponseEntity<Professor>(professorService.getProfessor(id), HttpStatus.OK);
	}

}
