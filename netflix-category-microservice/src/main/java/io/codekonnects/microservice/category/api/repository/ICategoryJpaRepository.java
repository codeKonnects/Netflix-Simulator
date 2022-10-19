package io.codekonnects.microservice.category.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.codekonnects.microservice.commons.entity.CategoryEntity;


@Repository("categoryJpaRepository")
public interface ICategoryJpaRepository extends CrudRepository<CategoryEntity, String> {

}
