package com.example.demo.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Alcohol")
@Getter
@Setter
public class AlcoholVO {
	
	@Id
	private int aid;
	
	private String name;
	
	private String category;
	
	private int lowestPrice;
	
	private int highestPrice;
	
	private int ml;
	
	private int abv;
	
	private String description;
	
}
