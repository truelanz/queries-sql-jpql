package com.devsuperior.uri2611.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {

	@Id
	private Long id;
	private String description;
	
	@OneToMany(mappedBy = "genre")
	private List<Movie> movies = new ArrayList<>();
	
	public Genre() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Movie> getMovies() {
		return movies;
	}
}
