package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/*
 * Elijah Olmos and Alex Vergara
 * Milestone
 * 01/29/2022
 */

public class UsersMapper implements RowMapper<UserEntity>{

	// NOTE CHANGED ALL USER MODEL TO USER ENTITY
	@Override
	public UserEntity mapRow(ResultSet resultset, int rowNum) throws SQLException {
		// create new user entity which will be used to set roles
		UserEntity user = new UserEntity(
				resultset.getLong("ID"),
				resultset.getString("USERNAME"),
				resultset.getString("PASSWORD"),
				// roles
				resultset.getString("ROLE")
				);
		
		return user;
	}

}
