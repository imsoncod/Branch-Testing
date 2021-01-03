package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AlcoholSearchDTO;
import com.example.demo.mapping.SearchMapping;
import com.example.demo.repository.SearchRepository;
import com.example.demo.vo.ViewSearchVO;

@Service
public class SearchService {
	
	@Autowired
	SearchRepository searchRepository;
	
	public List<AlcoholSearchDTO> basicSearch(String category, String sort){
		if(sort == null) sort = "popularScore";
		
		List<AlcoholSearchDTO> dto = new ArrayList<AlcoholSearchDTO>();
		List<SearchMapping> mapping;
		if(category.equals("전체")){
			mapping = searchRepository.findByAidIsNotNull(sortOption(dirOption(sort), sort));
		}else {
			mapping = searchRepository.findByCategory(category, sortOption(dirOption(sort), sort));
		}
		
		for (SearchMapping m : mapping) {
			dto.add(AlcoholSearchDTO.builder()
					.aid(m.getAid())
					.name(m.getName())
					.category(m.getCategory())
					.reviewCnt(m.getReviewCnt())
					.star(m.getStar())
					.build()
					);
		}	
		return dto;
	}
	
	public List<AlcoholSearchDTO> keywordSearch(String keyword, String sort){
		if(sort == null) sort = "popularScore";
		List<AlcoholSearchDTO> dto = new ArrayList<AlcoholSearchDTO>();
		List<SearchMapping> mapping = searchRepository.findByNameContaining(keyword, sortOption(dirOption(sort), sort));
		
		for (SearchMapping m : mapping) {
			dto.add(AlcoholSearchDTO.builder()
					.aid(m.getAid())
					.name(m.getName())
					.category(m.getCategory())
					.reviewCnt(m.getReviewCnt())
					.star(m.getStar())
					.build()
					);
		}	
		return dto;
	}
	
	//정렬 기준을 동적으로 설정
	private Sort sortOption(Direction direction, String property) {
		List<Order> orders = new ArrayList<Sort.Order>();
		orders.add(new Order(direction, property));
		orders.add(new Order(Direction.ASC, "name"));
		return Sort.by(orders);
	}
	
	//정렬 기준별 오름차순, 내림차순 구분
	private Direction dirOption(String sort) {
		switch(sort) {
		case "popularScore":
		case "star":
		case "loveCnt":
		case "highestPrice":
			return Sort.Direction.DESC;	
		}
		return Sort.Direction.ASC;
	}

}
