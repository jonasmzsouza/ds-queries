package com.devsuperior.uri2609;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// SQL
		List<CategorySumProjection> list = repository.search1();
		List<CategorySumDTO> result1 = list.stream().map(x -> new CategorySumDTO(x)).collect(Collectors.toList());
		System.out.println("\n*** SQL RESULT:");
		result1.forEach(p -> System.out.println(p));
		System.out.println("\n\n");
		
		// JPQL
		List<CategorySumDTO> result2 = repository.search2();
		System.out.println("\n*** JPQL RESULT:");
		result2.forEach(p -> System.out.println(p));
		
	}
}
