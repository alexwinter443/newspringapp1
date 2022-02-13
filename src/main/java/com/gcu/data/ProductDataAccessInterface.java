package com.gcu.data;

import java.util.List;

import com.gcu.model.ProductModel;

/*
 * Elijah Olmos and Alex vergara
 * Milestone
 * 11/7/2021
 */

public interface ProductDataAccessInterface {
	// interface to make dependency injection easier
	public ProductModel getById(int id);
	public List<ProductModel> getProducts();
	public List<ProductModel> searchProducts(String searchTerm);
	public int addOne(ProductModel newProduct);
	public boolean deleteOne(int id);
	public ProductModel updateOne(int idToUpdate, ProductModel updateProduct);
}
