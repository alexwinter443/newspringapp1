package com.gcu.data;

import java.util.List;

import com.gcu.model.ProductModel;

/*
 * Elijah Olmos and Alex vergara
 * Milestone
 * 02/07/2022
 */

/**
 * interface to make dependency injection easier
 */
public interface ProductDataAccessInterface {
	public ProductModel getById(int id);
	public List<ProductModel> getProducts();
	public List<ProductModel> searchProducts(String searchTerm);
	public int addOne(ProductModel newProduct);
	public boolean deleteOne(int id);
	public ProductModel updateOne(int idToUpdate, ProductModel updateProduct);
}
