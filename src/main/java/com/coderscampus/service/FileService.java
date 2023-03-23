package com.coderscampus.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.coderscampus.domain.Recipes.Recipe;

public class FileService {
	
	public List<Recipe> something() throws IOException {

		Reader in = new FileReader("recipes.txt");
		Iterable<CSVRecord> records = CSVFormat.DEFAULT

				.parse(in);
		return null;
	}

}
