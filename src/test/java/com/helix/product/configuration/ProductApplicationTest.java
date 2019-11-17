package com.helix.product.configuration;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ProductApplicationTest 
{   
    @Test
    public void testGetProductSuccess() throws URISyntaxException 
    {
        RestTemplate restTemplate = new RestTemplate();
        
        final String baseUrl = "http://localhost:8080/product/getProduct?id=1";
        URI uri = new URI(baseUrl);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        
        Assert.assertEquals(200, result.getStatusCodeValue());
    }
    
}


