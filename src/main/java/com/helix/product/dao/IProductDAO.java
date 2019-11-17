package com.helix.product.dao;

import com.helix.product.model.Product;

public interface IProductDAO {

	public Product getProductById(Long id);
	
	public int storeProduct(Product product);
	
}
