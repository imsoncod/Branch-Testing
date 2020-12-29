package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;
import com.example.demo.vo.UserVO;

@Service
public class UserService{

	@Autowired
	UserRepository userRepository;
	
	public List<UserVO> findAll(){
		List<UserVO> users = userRepository.findAll();
		return users;
	}
	
	public UserVO findByEmail(String email) {
		Optional<UserVO> users = userRepository.findByEmail(email);
		if(users.isPresent()) {
			return users.get();
		}else {
			return null;
		}
	}
	
	public UserVO save(UserVO user) {
		userRepository.save(user);
		return user;
	}
	
}
