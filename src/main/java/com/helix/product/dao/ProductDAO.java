package com.helix.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.helix.product.model.Product;

@Repository
public class ProductDAO implements IProductDAO {
		
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	class ProductRowMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setId(rs.getLong("id"));
			product.setName(rs.getString("name"));
			product.setQuantity(rs.getInt("quantity"));
			product.setSaleAmount(rs.getDouble("sale_amount"));
			
			return product;
		}
		
	}
	
	public Product getProductById(Long id) {
		return jdbcTemplate.queryForObject("select * from product where id = ?",
				new Object[] {id}, 
				new BeanPropertyRowMapper<Product>(Product.class));
	}
	
	public int storeProduct(Product product) {
		System.out.println("inside productDAO storeProduct method ..");
		System.out.println(product);
		return jdbcTemplate.update("insert into product(id, name, quantity, sale_amount, event_id, created_time) values (?, ?, ?, ?, ?, ?)", 
				new Object[] { product.getId(), product.getName(), product.getQuantity(), product.getSaleAmount(), 
						product.getEventId(), product.getCreatedTime() }
			); 
	}

}
