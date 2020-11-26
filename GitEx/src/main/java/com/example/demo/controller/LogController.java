package com.example.demo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;

@RequestMapping(value = "/log")
@Controller
public class LogController {
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	@GetMapping
	public Object logCheck() {
		logger.trace("Trace Level 테스트"); 
		logger.debug("DEBUG Level 테스트"); 
		logger.info("INFO Level 테스트"); 
		logger.warn("Warn Level 테스트"); 
		logger.error("ERROR Level 테스트");
		
		return "logCheck()";
	}

}
