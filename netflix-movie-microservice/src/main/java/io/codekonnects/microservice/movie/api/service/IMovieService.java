package io.codekonnects.microservice.movie.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.codekonnects.microservice.commons.dto.MovieDTO;
@Service
public interface IMovieService {
	MovieDTO insert(MovieDTO movie);
	MovieDTO update(MovieDTO movie);
	List<MovieDTO> getAll();

	MovieDTO findById(String id);
	void delete(String id);

}
