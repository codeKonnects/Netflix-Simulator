package io.codekonnects.microservice.commons.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
public class MovieDTO {
	private String id;
	private String title;
	@JsonBackReference
	private CategoryDTO category;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

}
