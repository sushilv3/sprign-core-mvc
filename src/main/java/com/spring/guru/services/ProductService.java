package com.spring.guru.services;

import java.util.List;

import com.spring.guru.domain.Product;

public interface ProductService {
	
	List<Product> listAllProducts();
	
	Product getproductById(Integer id);
	
	Product saveOrUpdateProduct(Product product);
	
	void deleteProduct(Integer id);
	
	

}
