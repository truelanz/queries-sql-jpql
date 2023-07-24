package com.devsuperior.uri2611;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Autowired
	private MovieRepository repository; 

	@Override
	public void run(String... args) throws Exception {

		//SQL
		System.out.println("\nSQL Query");
		List<MovieMinProjection> list = repository.search1("Action");
		List<MovieMinDTO> result1 = list.stream().map(x -> new MovieMinDTO(x)).collect(Collectors.toList());

		for(MovieMinDTO obj : result1) {
			System.out.println(obj);
		}

		//JPQL
		System.out.println("\nJPQL Query");
		List<MovieMinDTO> result2 = repository.search2("Action");

		for(MovieMinDTO obj : result2) {
			System.out.println(obj);
		}
	}
}
