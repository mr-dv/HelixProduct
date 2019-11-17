package com.helix.product.configuration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.helix.product.controller.ProductController;
import com.helix.product.dao.ProductDAO;
import com.helix.product.model.Product;
import com.helix.product.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ProductService productService;
    
    @MockBean
    private ProductDAO productDAO;

    @Test
    public void testGetProduct() throws Exception {
    	
    	Product product = new Product();
    	product.setId(new Long(1));
    	product.setName("book");
    	
    	given(productService.getProductById(new Long(1))).willReturn(product);
        
    	this.mockMvc.perform(get("http://localhost:8080/product/getProduct?id=1"))
        	.andDo(print())
        	.andExpect(status().isOk());

    }

    @Test
    public void testAddProduct() throws Exception {
    	String content = "{\"id\": 71, \"name\": \"book71\" }";

    	mockMvc.perform(put("http://localhost:8080/product/saveProduct")
    	           .contentType(MediaType.APPLICATION_JSON)
    	           .content(content.getBytes())
    	           .accept(MediaType.APPLICATION_JSON))
    	           .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

    }
}
