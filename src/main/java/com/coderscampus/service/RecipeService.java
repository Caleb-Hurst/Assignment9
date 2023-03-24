package com.coderscampus.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.domain.Recipes;

@Service
public class RecipeService {
	private FileService fileService;
	
	@Autowired
    public RecipeService(FileService fileService) {
        this.fileService = fileService;
    }
	public List<Recipes> allRecipes() throws IOException {
		List<Recipes> allRecipes = new ArrayList<>();
		allRecipes = fileService.readFile();
		return allRecipes;
	}

}
