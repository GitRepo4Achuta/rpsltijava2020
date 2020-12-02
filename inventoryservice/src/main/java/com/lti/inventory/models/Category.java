package com.lti.inventory.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
@Entity
@Table(name="Inventory_Category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Category_Seq")
	@SequenceGenerator(name = "Category_Seq",sequenceName = "INVENTORY_CATEGORY_SEQ",allocationSize = 1)
	@Column(name="Category_Id")
	private long categoryId;
	@Column(name="Category_Name",nullable = false,length = 100)
	private String name;   
	@OneToMany(mappedBy ="category",
			  cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval = true)	 
    @JsonProperty("products")			  
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY) 
	private List<Product> productList;

}
