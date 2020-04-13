package com.mitocode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SALE_DETAIL")
public class SaleDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SALE_DETAIL")
	private Integer idSaleDetail;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_SALE", nullable = false, foreignKey = @ForeignKey(name = "FK_sale_detail"))
	private Sale sale;
	
	@ManyToOne
	@JoinColumn(name = "ID_PRODUCT", nullable = false, foreignKey = @ForeignKey(name = "FK_product_detail"))
	private Product product;

}
