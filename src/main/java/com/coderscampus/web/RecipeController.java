package com.coderscampus.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.domain.Recipes;
import com.coderscampus.service.FileService;
import com.coderscampus.service.RecipeService;

@RestController
public class RecipeController {
	private RecipeService recipeService;
	
	@Autowired
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	@GetMapping("/all-recipes")
	public List<Recipes> all() throws IOException {		
		return recipeService.allRecipes();
	}
	@GetMapping("/")
	public String studff() {
		return "hey";
	}
	

}
