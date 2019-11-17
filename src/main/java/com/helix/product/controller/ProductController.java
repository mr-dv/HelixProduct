package com.helix.product.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.helix.product.model.Product;
import com.helix.product.service.ProductService;

import lombok.Setter;

@RestController
@EnableAutoConfiguration
@RequestMapping(path = "/product", produces = "application/json")
public class ProductController {

	@Autowired
	@Setter
	private ProductService productService;

	@GetMapping("/getProduct")
	public ResponseEntity<Product> getProduct(@RequestParam Long id) {
		Product p = productService.getProductById(id);
		ResponseEntity<Product> result = new ResponseEntity<Product>(p, HttpStatus.OK);
		return result;
	}
	
	@PutMapping("/saveProduct")
	public ResponseEntity<Integer> storeProductToDb(@RequestBody Product product) {
		System.out.println("inside storeProductToDb .. printing product ..");
		System.out.println(product);
		
		if (product != null) {
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			Random random = new Random();
			String eventId = df.format(date) + random.nextInt(1000000);
			
			product.setEventId(eventId);
			LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of(("GMT")));
			product.setCreatedTime(localDateTime);
		}
		
		int rowInserted = productService.storeProduct(product);
		ResponseEntity<Integer> result = new ResponseEntity<Integer>(rowInserted, HttpStatus.OK);
		return result;
	}
	
}
