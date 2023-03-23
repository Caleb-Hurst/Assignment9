package com.coderscampus.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {
	@GetMapping("/foo")
	public String stuff() {
		return"hello";
	}
	

}
