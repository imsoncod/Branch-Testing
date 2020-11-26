package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/")
@Controller
public class TestController {

	@GetMapping
	@ResponseBody
	public Object statusCheck() {
		return "Server Status : ON";
	}
	
}
