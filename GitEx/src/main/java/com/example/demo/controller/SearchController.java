package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.WrapperDTO;
import com.example.demo.service.SearchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/alcohol")
@Api(value = "Alcohol", description = "API")
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@ApiOperation(value = "주류 조회 & 정렬")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "category", required = true, dataType = "string", paramType = "query",
        		example = "전체",
        		value = "전체\n양주\n와인\n세계맥주"),
        @ApiImplicitParam(name = "sort", required = true, dataType = "string", paramType = "query",
        		example = "popularScore",
        		value = "인기순 : popularScore(default)\n"
        				+ "별점 높은 순 : star\n"
        				+ "찜 많은 순 : loveCnt\n"
        				+ "도수순 : abv\n"
        				+ "가격낮은순 : lowestPrice\n"
        				+ "가격높은순 : highestPrice")
	})
	@GetMapping
	@ResponseBody
	public WrapperDTO basicSearch(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String category = request.getParameter("category");
		String sort = request.getParameter("sort");
		if(category == null) {
			response.sendError(400, "Bad Request");
			return null;
		}
		return new WrapperDTO(searchService.basicSearch(category, sort));
	}
	
	
	@ApiOperation(value = "키워드로 주류 검색 & 정렬")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "keyword", required = true, dataType = "string", paramType = "query",
        		example = "주류 이름",
        		value = "주류 이름"),
        @ApiImplicitParam(name = "sort", required = true, dataType = "string", paramType = "query",
        		example = "popularScore",
        		value = "인기순 : popularScore(default)\n"
        				+ "별점 높은 순 : star\n"
        				+ "찜 많은 순 : loveCnt\n"
        				+ "도수순 : abv\n"
        				+ "가격낮은순 : lowestPrice\n"
        				+ "가격높은순 : highestPrice")
	})
	@GetMapping(value = "/search")
	@ResponseBody
	public WrapperDTO keywordSearch(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String keyword = request.getParameter("keyword");
		String sort = request.getParameter("sort");
		if(keyword == null) {
			response.sendError(400, "Bad Request");
			return null;
		}
		return new WrapperDTO(searchService.keywordSearch(keyword, sort));
	}
	
}
