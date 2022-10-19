package io.codekonnects.microservice.movie.api.repository;

import org.springframework.data.repository.CrudRepository;

import io.codekonnects.microservice.commons.entity.MovieEntity;
public interface IMovieJpaRepository extends CrudRepository<MovieEntity, String> {

}
