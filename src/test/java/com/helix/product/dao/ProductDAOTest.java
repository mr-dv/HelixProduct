package com.helix.product.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.helix.product.dao.ProductDAO;
import com.helix.product.model.Product;

@RunWith(SpringRunner.class)
public class ProductDAOTest {

	@TestConfiguration
	static class ProductDAOTestContextConfiguration {
		
		@Bean
		public ProductDAO productDAO() {
			return new ProductDAO();
			
		}
	}
	
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
		Product product = productDAO.getProductById(new Long(1));
		assertTrue(product.getName().equalsIgnoreCase(name));
	}
	
	@Test
	public void testProductQuantity() {
		int quantity = 5;
		Product product = productDAO.getProductById(new Long(1));
		assertTrue(product.getQuantity() == quantity);
	}
}
