package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.model.ProductMapper;
import com.gcu.model.ProductModel;
import com.gcu.util.DatabaseException;

/*
 * Elijah Olmos and Alex vergara
 * Milestone
 * 02/07/2022
 */

@Repository
public class ProductDataService implements ProductDataAccessInterface {
	// jdbctemplate is a Spring class used to shorten the amount of code needed to
	// interact with a SQL database
	// dataSource is defined in the application.properties file (src/main/resources)
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	// constructor
	public ProductDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * get a single product by ID
	 * 
	 * @param id The ID of the product to be retrieved
	 * @return ProductModel
	 */
	@Override
	public ProductModel getById(int id) {
		try {
			// query but easier with jdbc
			ProductModel result = jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = ?",
					new ProductMapper(),
					new Object[] { id });
			// return the product
			return result;
		} catch (Exception e) {
			// Log stack trace & throw custom exception to caller
			e.printStackTrace();
			throw new DatabaseException(e, "Database exception");
		}
	}

	/**
	 * get all products
	 * 
	 * @return List<ProductModel>
	 */
	// get all products
	@Override
	public List<ProductModel> getProducts() {
		try {
			// query for all properties of all products
			List<ProductModel> products = jdbcTemplate.query("SELECT * FROM products", new ProductMapper());
			// System.out.println("In data service first product id " +
			// products.get(0).getID());
			return products;
		} catch (Exception e) {
			// Log stack trace & throw custom exception to caller
			e.printStackTrace();
			throw new DatabaseException(e, "Database exception");
		}
	}

	/**
	 * search for products by a search term string
	 * 
	 * @param searchTerm serach term to be used in the search
	 * @return List<ProductModel>
	 */
	// search by a given term
	@Override
	public List<ProductModel> searchProducts(String searchTerm) {
		try {
			// SQL query with jdbc for searching product names
			return jdbcTemplate.query("SELECT * FROM products WHERE NAME LIKE ?",
					new ProductMapper(),
					new Object[] { "%" + searchTerm + "%" });
		} catch (Exception e) {
			// Log stack trace & throw custom exception to caller
			e.printStackTrace();
			throw new DatabaseException(e, "Database exception");
		}
	}

	/**
	 * add a new product to the database
	 * 
	 * @param newProduct the product to be added
	 * @return int
	 */
	// adding a new product to the database
	@Override
	public int addOne(ProductModel newProduct) {
		try {
			// insert statement with protection against SQL injections
			return jdbcTemplate.update(
					"INSERT INTO products (NAME, PRICE, LOCATION, DETAILS, AVAILABILITY, CONTACT, IMAGE) VALUES (?,?,?,?,?,?,?)",
					newProduct.getVacationName(),
					newProduct.getPrice(),
					newProduct.getLocation(),
					newProduct.getDetails(),
					newProduct.getAvailability(),
					newProduct.getContact(),
					newProduct.getImage());
		} catch (Exception e) {
			// Log stack trace & throw custom exception to caller
			e.printStackTrace();
			throw new DatabaseException(e, "Database exception");
		}
	}

	/**
	 * delete a product from the database
	 * 
	 * @param id the ID of the product to be deleted
	 * @return boolean
	 */
	// delete a product from database by id
	@Override
	public boolean deleteOne(int id) {
		try {
			int updateResult = jdbcTemplate.update(
					"DELETE FROM products WHERE id = ?",
					new Object[] { id });
			System.out.println("data service: Trying to delete" + id);
			System.out.println("data service: result: " + updateResult);
			return (updateResult > 0);
		} catch (Exception e) {
			// Log stack trace & throw custom exception to caller
			e.printStackTrace();
			throw new DatabaseException(e, "Database exception");
		}
	}

	/**
	 * update a product in the database
	 * 
	 * @param idToUpdate    the ID of the product to be updated
	 * @param updateProduct the ProductModel to replace the existing product
	 * @return ProductModel
	 */
	// update a product by id with new product details
	@Override
	public ProductModel updateOne(int idToUpdate, ProductModel updateProduct) {
		try {
			// sql query with injection protection
			int result = jdbcTemplate.update(
					"UPDATE products SET NAME = ?, PRICE = ?, LOCATION = ?, DETAILS = ?, AVAILABILITY = ?, CONTACT = ?, IMAGE = ? WHERE id = ?",
					updateProduct.getVacationName(),
					updateProduct.getPrice(),
					updateProduct.getLocation(),
					updateProduct.getDetails(),
					updateProduct.getAvailability(),
					updateProduct.getContact(),
					updateProduct.getImage(),
					idToUpdate);
			if (result > 0) {
				return updateProduct;
			} else {
				return null;
			}
		} catch (Exception e) {
			// Log stack trace & throw custom exception to caller
			e.printStackTrace();
			throw new DatabaseException(e, "Database exception");
		}
	}
}
