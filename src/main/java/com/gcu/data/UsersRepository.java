package com.gcu.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.gcu.model.UserEntity;

/*
 * Elijah Olmos and Alex Vergara
 * Milestone
 * 01/29/2022
 */

 /**
  * crud repository handles most of the operations
  */
@Component
public interface UsersRepository extends CrudRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);
}
