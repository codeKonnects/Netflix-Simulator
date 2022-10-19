package io.codekonnects.microservices.user.api.controller;

import io.codekonnects.microservices.user.api.model.dto.UserDTO;
import io.codekonnects.microservices.user.api.model.request.UserCreateRequestModel;
import io.codekonnects.microservices.user.api.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping(path = "/users")
public class UserController {
	private UserServiceImpl service;

	@Autowired
	public UserController(UserServiceImpl service) {
		this.service = service;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserCreateRequestModel userRequest) {
		if(service.findByEmail(userRequest.getEmail()) != null) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDTO userDTO = modelMapper.map(userRequest, UserDTO.class);
		userDTO = service.insert(userDTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDTO> getById(@PathVariable("id") String id) {
		UserDTO userDto = service.findById(id);
		return (userDto != null) ? ResponseEntity.status(HttpStatus.OK).body(userDto) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}
