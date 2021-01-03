package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AlcoholSearchDTO {
	
	private int aid;
	
	private String name;
	
	private String category;
	
	private double star;
	
	private int reviewCnt;
	
}
