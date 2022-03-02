package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/*
 * Elijah Olmos and Alex vergara
 * Milestone
 * 02/07/2022
 */

/**
 * RowMapper for mapping Product Rows
 */
public class ProductMapper implements RowMapper<ProductModel> {
	
	// match product mapping with product model for easier database manipulation
	@Override
	public ProductModel mapRow(ResultSet resultSet, int i) throws SQLException {
		ProductModel product = new ProductModel(
				resultSet.getInt("ID"),
				resultSet.getString("NAME"),
				resultSet.getInt("PRICE"),
				resultSet.getString("LOCATION"),
				resultSet.getString("DETAILS"),
				resultSet.getInt("AVAILABILITY"),
				resultSet.getString("CONTACT"),
				resultSet.getString("IMAGE")
				);
		// System.out.println("in product mapper id = " + product.getId() + " image = " + product.getImage());
		
		return product;
	}
}
