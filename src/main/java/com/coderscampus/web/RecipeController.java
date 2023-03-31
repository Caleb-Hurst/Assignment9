package com.coderscampus.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.domain.Recipes;
import com.coderscampus.service.FileService;

@RestController
public class RecipeController {
	@Autowired
	private FileService fileService;
	
	
	@GetMapping("/all-recipes")
	public List<Recipes> all() throws IOException {		
		
		return fileService.readFile();
		
	}
	@GetMapping("/vegetarian")
	public List<Recipes> vegetarian() throws IOException {
		List<Recipes> vegetarian = fileService.readFile()
		.stream().filter(recipe -> recipe.getVegetarian())
		.collect(Collectors.toList());
		return vegetarian;
	}
	
	@GetMapping("/vegan")
	public List<Recipes> vegan() throws IOException{
		List<Recipes> vegan = fileService.readFile()
				.stream().filter(t -> t.getVegan())
				.collect(Collectors.toList());
		return vegan;
	}
	
	@GetMapping("/gluten-free")
	public List<Recipes> glutenFree() throws IOException{
		List<Recipes> glutenFree = fileService.readFile()
				.stream().filter(t -> t.getGlutenFree())
				.collect(Collectors.toList());
		return glutenFree;
	}
	
	@GetMapping("vegan-and-gluten-free")
	public List<Recipes> veganAndGlutenFree() throws IOException{
		List<Recipes> veganAndGlutenFree = fileService.readFile()
				.stream().filter(t -> t.getGlutenFree())
				.filter(t -> t.getVegan())
				.collect(Collectors.toList());
		return veganAndGlutenFree;
	}
	

}
