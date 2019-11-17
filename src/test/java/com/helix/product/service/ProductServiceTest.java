package com.helix.product.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.helix.product.dao.ProductDAO;
import com.helix.product.model.Product;
import com.helix.product.service.ProductService;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

	@TestConfiguration
	static class ProductServiceTestContextConfiguration {
		
		@Bean
		public ProductService productService() {
			return new ProductService();
			
		}
	}
	
	
	@Autowired
	private ProductService productService;
	
	@MockBean 
	private ProductDAO productDAO;
	
	@Before
	public void setUp() {
		Product product = new Product();
		product.setId(new Long(1));
		product.setName("book");
		product.setQuantity(5);
		
		Mockito.when(productDAO.getProductById(new Long(1))).thenReturn(product);
	}

	@Test
	public void testProductName() {
		String name = "book";
		Product product = productService.getProductById(new Long(1));
		assertTrue(product.getName().equalsIgnoreCase(name));
	}
	
	@Test
	public void testProductQuantity() {
		int quantity = 5;
		Product product = productService.getProductById(new Long(1));
		assertTrue(product.getQuantity() == quantity);
	}
}
