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
	public List<Recipes> readFile() throws IOException {
		List<Recipes> recipes = new ArrayList<>();
		Reader in = new FileReader("recipes.txt");
		Iterable<CSVRecord> records = CSVFormat.DEFAULT
				.withDelimiter(',')
				.withIgnoreSurroundingSpaces(true)
				.withHeader()
				.withSkipHeaderRecord()
				.parse(in);
		
		for (CSVRecord record : records) {	       
	        Integer cookMin = Integer.parseInt(record.get(0));
	        Boolean dairyFree = Boolean.parseBoolean(record.get(1));
	        Boolean glutenFree = Boolean.parseBoolean(record.get(2));
	        String instructions  = record.get(3);
	        Double prepMin = Double.parseDouble(record.get(4));
	        Double pricePerServing = Double.parseDouble(record.get(5));
	        Integer readyInMinutes = Integer.parseInt(record.get(6));
	        Integer servings = Integer.parseInt(record.get(7));
	        Double spoonacularScore = Double.parseDouble(record.get(8));
	        String title = record.get(9);
	        Boolean vegan = Boolean.parseBoolean(record.get(10));
	        Boolean vegatarian = Boolean.parseBoolean(record.get(11));
	        Recipes recipe = new Recipes
	        		(cookMin, dairyFree,glutenFree
	        		,instructions,prepMin
	        		,pricePerServing,readyInMinutes
	        		,servings,spoonacularScore,title
	        		,vegan,vegatarian);
	        recipes.add(recipe);
	    }
		return recipes;
	}

}
