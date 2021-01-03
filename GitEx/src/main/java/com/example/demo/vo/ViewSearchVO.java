package com.example.demo.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ViewSearch")
@Getter
@Setter
public class ViewSearchVO {
	
	@Id
	private int aid;
	
	private String name;
	
	private String category;
	
	private int lowestPrice;
	
	private int highestPrice;
	
	private double abv;
	
	private double star;
	
	private int loveCnt;
	
	private int reviewCnt;
	
	private double popularScore;
	
}
