package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/*
 * Elijah Olmos and Alex Vergara
 * Milestone
 * 01/29/2022
 */
/**
 * RowMapper for mapping Product Rows
 */
public class UserModelMapper implements RowMapper<UserModel>{

	// NOTE CHANGED ALL USER MODEL TO USER ENTITY
	@Override
	public UserModel mapRow(ResultSet resultset, int rowNum) throws SQLException {
		// create new user entity which will be used to set roles
		UserModel user = new UserModel(
				resultset.getLong("ID"),
				resultset.getString("USERNAME"),
				resultset.getString("PASSWORD"),
				resultset.getString("FIRST_NAME"),
				resultset.getString("LAST_NAME"),
				resultset.getString("EMAIL"),
				resultset.getString("PHONE"),
				// roles
				resultset.getString("ROLE")
				);
		
		return user;
	}

}
