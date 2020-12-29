package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserService;
import com.example.demo.vo.UserVO;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<UserVO>> getAllUsers(){
		List<UserVO> users = userService.findAll();
		return new ResponseEntity<List<UserVO>>(users, HttpStatus.OK);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<UserVO> getUserByEmail(@RequestHeader(value = "email") String email){
		UserVO user = userService.findByEmail(email);
		
		return new ResponseEntity<UserVO>(user, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<UserVO> save(@RequestBody UserVO user){
		return new ResponseEntity<UserVO>(userService.save(user), HttpStatus.OK);
	}
	
}
