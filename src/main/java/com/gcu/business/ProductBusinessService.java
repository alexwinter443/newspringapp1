package com.gcu.business;

import java.util.List;

import com.gcu.data.ProductDataService;
import com.gcu.model.ProductModel;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * Elijah Olmos and Alex Vergara
 * Milestone
 * 02/07/2022
 */

 /**
  * Business Service for Product interactions
  */
public class ProductBusinessService implements ProductBusinessServiceInterface {
	
	// dependency injection
	// mysql database 
	@Autowired
	ProductDataService productsDAO;

	/**
	 * get all products using the data service
	 */
	@Override
	public List<ProductModel> getProducts() {		
		return productsDAO.getProducts();
	}

	@Override
	public void init() {
		System.out.println("Init method of Product Business Service appears to be working.");
	}

	@Override
	public void destroy() {
		System.out.println("Destroy method of the Product Business Service was just called.");
	}

	/**
	 *  get a single product by id
	 * @param id the id of the product to get
	 */
	@Override
	public ProductModel getOne(int id) {
		return productsDAO.getById(id);
	}

	/**
	 * search products by a search term
	 * @param searchTerm the search term to search by
	 */
	@Override
	public List<ProductModel> searchProducts(String searchTerm) {
		return productsDAO.searchProducts(searchTerm);
	}

	/**
	 * add a product to the database
	 * @param newProduct the product to add
	 */
	@Override
	public int addOne(ProductModel newProduct) {
		return productsDAO.addOne(newProduct);
	}

	/**
	 * delete a product from the database
	 * @param id the id of the product to delete
	 */
	@Override
	public boolean deleteOne(int id) {
		return productsDAO.deleteOne(id);
	}

	/**
	 * update a product in the database
	 * @param id the id of the product to update
	 * @param updateProduct the product to update
	 */
	@Override
	public ProductModel updateOne(int idToUpdate, ProductModel updateProduct) {
		return productsDAO.updateOne(idToUpdate, updateProduct);
	}
}
