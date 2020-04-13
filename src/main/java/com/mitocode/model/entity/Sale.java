package com.mitocode.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SALE")
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SALE")
	private Integer idSale;
	
	@Column(name = "DATE")
	private LocalDateTime date;
	
	@Column(name = "AMOUNT")
	private double amount;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERSON", nullable = false, foreignKey = @ForeignKey(name = "FK_person_sale"))
	private Person person;
	
	@OneToMany(	mappedBy = "sale", 
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY)
	private List<SaleDetail> saleDetail;	

}
