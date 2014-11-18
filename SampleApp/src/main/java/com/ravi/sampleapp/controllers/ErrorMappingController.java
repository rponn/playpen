package com.ravi.sampleapp.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorMappingController implements ErrorController{

	private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Default Error Page need to be implemented!";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
