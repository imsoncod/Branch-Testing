package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.UserVO;

//JpaRepository 인터페이스에 선언되어 있지 않은 메소드를 별도로 선언
//SQL문을 메소드명으로 작성
@Repository
public interface UserRepository extends JpaRepository<UserVO, Integer>{
	
	public Optional<UserVO> findByEmail(String email);
	
}
