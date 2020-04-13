package com.mitocode.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PERSON")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSON")
	private Integer idPerson;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "LASTNAME")
	private String lastname;
	
	@JsonIgnore
	@OneToMany(	mappedBy = "person", 
				cascade = CascadeType.ALL, 
				fetch = FetchType.LAZY)
	private List<Sale> sale;

}
