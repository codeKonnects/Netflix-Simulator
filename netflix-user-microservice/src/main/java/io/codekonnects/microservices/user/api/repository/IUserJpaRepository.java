package io.codekonnects.microservices.user.api.repository;

import io.codekonnects.microservices.user.api.model.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface IUserJpaRepository extends MongoRepository<UserEntity, String> {

	UserEntity findByEmail(String email);
	UserEntity findUserById(String id);
	
}
