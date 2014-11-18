package com.ravi.sampleapp.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
	
	private Logger log = Logger.getLogger(ExceptionHandlerController.class);
	
	@ExceptionHandler
	void handleAllExceptions(Exception e, HttpServletResponse response) throws IOException {
		log.info("In the exception handler ..."+HttpStatus.BAD_REQUEST.value());
	    response.sendError(HttpStatus.BAD_REQUEST.value());
	}
}