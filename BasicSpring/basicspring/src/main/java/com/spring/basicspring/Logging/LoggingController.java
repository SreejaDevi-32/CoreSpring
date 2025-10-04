package com.spring.basicspring.Logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/log")
public class LoggingController {
	private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);
	
	@GetMapping("/testLogger")
	public String testLogging() {
		logger.trace("Trace message - LoggerController class");
		logger.debug("Debug message -  LoggerController class");
		logger.info("Info Message - LoggerController class");
		logger.warn("Warning message - LoggingController class");
		logger.error("Error Message - LoggingController class");
		return "Check log test!";
	}

}
