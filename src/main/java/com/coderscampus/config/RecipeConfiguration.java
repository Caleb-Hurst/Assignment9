package com.coderscampus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coderscampus.domain.Recipes;

@Configuration
public class RecipeConfiguration {

	@Bean
	public Recipes recipe() {
		return new Recipes();
	}
}
