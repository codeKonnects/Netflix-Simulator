package io.codekonnects.microservice.category.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.codekonnects.microservice.commons.dto.CategoryDTO;
@Service
public interface ICategoryService {

	 CategoryDTO insert(CategoryDTO category);
	

	CategoryDTO update(CategoryDTO category);


	List<CategoryDTO> getAll();

	CategoryDTO findById(String id);

	 void delete(String id);
	
}
