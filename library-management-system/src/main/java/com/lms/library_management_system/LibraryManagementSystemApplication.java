package com.lms.library_management_system;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Main class for the Library Management System Spring Boot application.
 */
@SpringBootApplication
public class LibraryManagementSystemApplication {

	/**
	 * Bean definition for ModelMapper.
	 * Used for mapping DTOs to Entities and vice versa with advanced configuration.
	 *
	 * @return A configured instance of ModelMapper.
	 */
	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		// Configure matching strategy
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STANDARD)
				.setFieldMatchingEnabled(true)
				.setSkipNullEnabled(true);

		return modelMapper;
	}

	/**
	 * Main method to run the Spring Boot application.
	 *
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}
}
