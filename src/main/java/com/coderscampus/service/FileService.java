package com.coderscampus.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.domain.Recipes;
@Service
public class FileService {

	private Recipes recipe;
	
	@Autowired
	public FileService(Recipes recipe) {
		this.recipe = recipe;
	}
	public List<Recipes> readFile() throws IOException {
		List<Recipes> food = new ArrayList<>();
		Reader in = new FileReader("recipes.txt");
		Iterable<CSVRecord> records = CSVFormat.DEFAULT
				.withIgnoreSurroundingSpaces()
				.withHeader()
				.withSkipHeaderRecord()
				.parse(in);
		for (CSVRecord record : records) {
	        
	        recipe.setCookingMinutes(Integer.parseInt(record.get(0)));
	        recipe.setDairyFree(Boolean.parseBoolean(record.get(1)));
	        recipe.setGlutenFree(Boolean.parseBoolean(record.get(2)));
	        recipe.setInstructions(record.get(3));
	        recipe.setPreparationMinutes(Double.parseDouble(record.get(4)));
	        recipe.setPricePerServing(Double.parseDouble(record.get(5)));
	        recipe.setReadyInMinutes(Integer.parseInt(record.get(6)));
	        recipe.setServings(Integer.parseInt(record.get(7)));
	        recipe.setSpoonacularScore(Double.parseDouble(record.get(8)));
	        recipe.setTitle(record.get(9));
	        recipe.setVegan(Boolean.parseBoolean(record.get(10)));
	        recipe.setVegetarian(Boolean.parseBoolean(record.get(11)));

	        food.add(recipe);
	    }
		return food;
	}

}
