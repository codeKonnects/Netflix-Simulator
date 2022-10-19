package io.codekonnects.microservice.movie.api.request;

import javax.validation.constraints.NotNull;
public class MovieUpdateRequestModel extends MovieCreateRequestModel {
	@NotNull(message = "id cannot be null")
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
