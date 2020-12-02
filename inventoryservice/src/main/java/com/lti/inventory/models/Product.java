package com.lti.inventory.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="Inventory_Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Product_Seq")
    @SequenceGenerator(name = "Product_Seq",sequenceName = "INVENTORY_PRODUCT_SEQ",allocationSize = 1)
    @Column(name="Product_Id")
	private long productId;
    @Column(name="Product_Name",nullable = false,length = 100)
	private String productName;
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name="Product_DOP")
	private LocalDate dop;
    @Column(name="Product_Cost")
	private long cost;	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "Category_Id"), name = "Category_Id")
	@JsonIgnore
	private Category category;

	
}
