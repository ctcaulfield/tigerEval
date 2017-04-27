package com.codd.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codd.service.ProgramService;
import com.codd.model.Program;

@Controller
@RequestMapping("/program")
public class ProgramController {
	
	@Autowired
	private ProgramService programService;
	
	@RequestMapping(value="getByCoordinator/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getByCoordinator(@PathVariable("id") int id){
		if(id > 0){
			return new ResponseEntity<>(programService.getByCoordinator(id), HttpStatus.OK);
		}else{
			return new ResponseEntity<>("There is no coordinator with that id", HttpStatus.BAD_REQUEST);
		}
	}
}
