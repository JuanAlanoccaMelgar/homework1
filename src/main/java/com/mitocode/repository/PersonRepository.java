package com.mitocode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.entity.Person;

@Repository("personRepository")
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
