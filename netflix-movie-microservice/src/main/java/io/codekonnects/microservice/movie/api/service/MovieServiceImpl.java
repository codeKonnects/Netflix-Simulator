package io.codekonnects.microservice.movie.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.codekonnects.microservice.commons.dto.MovieDTO;
import io.codekonnects.microservice.commons.entity.MovieEntity;
import io.codekonnects.microservice.movie.api.repository.IMovieJpaRepository;
@Service("movieService")
public class MovieServiceImpl implements IMovieService {
	private IMovieJpaRepository repository;

	@Autowired
	public MovieServiceImpl(IMovieJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public MovieDTO insert(MovieDTO movie) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		MovieEntity movieEntity = modelMapper.map(movie, MovieEntity.class);
		
		movieEntity.setId(UUID.randomUUID().toString());
		
		movieEntity = repository.save(movieEntity);
		
		movie = modelMapper.map(movie, MovieDTO.class);
		
		return movie;
	}
	
	@Override
	public MovieDTO update(MovieDTO movie) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		MovieEntity movieEntity = modelMapper.map(movie, MovieEntity.class);
		
		movieEntity = repository.save(movieEntity);
		
		movie = modelMapper.map(movie, MovieDTO.class);
		
		return movie;
	}

	@Override
	public MovieDTO findById(String id) {
		MovieEntity movie = repository.findById(id).orElse(null);
		
		if(movie == null)
			return null;
		
		MovieDTO movieDTO = new ModelMapper().map(movie, MovieDTO.class);
		
		return movieDTO;
	}
	
	@Override
	public List<MovieDTO> getAll() {
		ArrayList<MovieEntity> movies = (ArrayList<MovieEntity>) repository.findAll();
		
		ModelMapper modelMapper = new ModelMapper();
		
		List<MovieDTO> moviesDTO = movies
				  .stream()
				  .map(movie -> modelMapper.map(movie, MovieDTO.class))
				  .collect(Collectors.toList());
		
		return moviesDTO;
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
	}

}
