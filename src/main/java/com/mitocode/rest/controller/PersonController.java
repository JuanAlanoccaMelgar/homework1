package com.mitocode.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.entity.Person;
import com.mitocode.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	@Qualifier("personService")
	private PersonService personService;
	
	@GetMapping
	public ResponseEntity<List<Person>> listar(){
		List<Person> list = personService.listAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> getById(@PathVariable("id") Integer id) {
		Person obj = personService.listById(id);
		return (obj != null ? new ResponseEntity<Person>(obj, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> register(@RequestBody Person person) {
		Person obj = personService.register(person);		
		return (obj != null ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}

}
