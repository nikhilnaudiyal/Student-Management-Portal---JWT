package com.bct.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swagger")

public class SwaggerController {

	@GetMapping(path="/hello")
	public String hello() {
		return "Hello This is Swagger";
	}
}
