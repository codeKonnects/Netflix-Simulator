package io.codekonnects.microservice.commons.dto;

import java.util.ArrayList;
import java.util.List;
public class CategoryDTO {
	private String id;
	private String name;
	private List<MovieDTO> movies = new ArrayList<MovieDTO>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MovieDTO> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieDTO> movies) {
		this.movies = movies;
	}
	
}
