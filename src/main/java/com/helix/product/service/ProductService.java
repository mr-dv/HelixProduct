package com.helix.product.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helix.product.dao.ProductDAO;
import com.helix.product.model.Product;

import lombok.Setter;

@Service
@Transactional
public class ProductService implements IProductService {

	@Autowired 
	@Setter
	private ProductDAO productDAO; 
	
	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public Product getProductById(Long id) {
		return productDAO.getProductById(id);
	}
	
	@Override
	public int storeProduct(Product product) {
		return productDAO.storeProduct(product);
	}
	
}
