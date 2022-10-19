package io.codekonnects.microservices.user.api.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import io.codekonnects.microservices.user.api.model.dto.UserDTO;
public interface IUserService extends UserDetailsService {
	UserDTO insert(UserDTO user);
	UserDTO findByEmail(String email);
	UserDTO findById(String id);
	
}
