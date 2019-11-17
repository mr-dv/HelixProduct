package com.helix.product.service;

import com.helix.product.model.Product;

public interface IProductService {

	public Product getProductById(Long id);
	
	public int storeProduct(Product product);
}
