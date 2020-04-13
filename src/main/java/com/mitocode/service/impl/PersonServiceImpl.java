package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mitocode.model.entity.Person;
import com.mitocode.repository.PersonRepository;
import com.mitocode.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	@Qualifier("personRepository")
	private PersonRepository personRepository;

	@Override
	public Person register(Person obj) {
		return personRepository.save(obj);
	}

	@Override
	public Person modify(Person obj) {
		return personRepository.save(obj);
	}

	@Override
	public List<Person> listAll() {
		return personRepository.findAll();
	}

	@Override
	public Person listById(Integer id) {
		Optional<Person> obj = personRepository.findById(id);
		return obj.isPresent() ? obj.get() : null;
	}

	@Override
	public boolean remove(Integer id) {
		personRepository.deleteById(id);
		return true;
	}

}
