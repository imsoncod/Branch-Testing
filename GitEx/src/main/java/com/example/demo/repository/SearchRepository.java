package com.example.demo.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.mapping.SearchMapping;
import com.example.demo.vo.ViewSearchVO;

@Repository
public interface SearchRepository extends JpaRepository<ViewSearchVO, Integer>{
	
	//전체 주류 조회
	public List<SearchMapping> findByAidIsNotNull(Sort sort);
	
	//카테고리별 주류 조회
	public List<SearchMapping> findByCategory(String category, Sort sort);
	
	//주류명으로 검색해서 조회
	public List<SearchMapping> findByNameContaining(String name, Sort sort);
	
}
