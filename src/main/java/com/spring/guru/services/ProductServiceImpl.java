package com.spring.guru.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.guru.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private Map<Integer, Product> products;

	public ProductServiceImpl() {
		loadProducts();
	}

	@Override
	public List<Product> listAllProducts() {

		System.out.println("+++++++++++++++++++++++++++++++++++++");
		return new ArrayList<>(products.values());
	}

	public void loadProducts() {
		products = new HashMap<>();
		List<Product> productList = Arrays.asList(
				new Product(1, "Product 1", new BigDecimal(550.50), "https://picsum.photos/100/100"),
				new Product(2, "Product 2", new BigDecimal(650.50), "https://picsum.photos/100/100"),
				new Product(3, "Product 3", new BigDecimal(560.50), "https://picsum.photos/100/100"),
				new Product(4, "Product 4", new BigDecimal(570.50), "https://picsum.photos/100/100"),
				new Product(5, "Product 5", new BigDecimal(850.50), "https://picsum.photos/100/100"),
				new Product(6, "Product 6", new BigDecimal(950.50), "https://picsum.photos/100/100"),
				new Product(7, "Product 7", new BigDecimal(590.50), "https://picsum.photos/100/100"),
				new Product(8, "Product 8", new BigDecimal(5150.50), "https://picsum.photos/100/100"),
				new Product(9, "Product 9", new BigDecimal(1550.50), "https://picsum.photos/100/100"),
				new Product(10, "Product 10", new BigDecimal(5050.50), "https://picsum.photos/100/100"));

		products = productList.stream().collect(Collectors.toMap(product -> product.getId(), product -> product));

//		Product p1 = new Product(1, "Product 1", new BigDecimal(550.50), "https://picsum.photos/100/100");
//		
//		Product p2 = new Product(2, "Product 2", new BigDecimal(650.50), "https://picsum.photos/100/100");
//		
//		Product p3 = new Product(3, "Product 3", new BigDecimal(560.50), "https://picsum.photos/100/100");
//		
//		Product p4 = new Product(4, "Product 4", new BigDecimal(570.50), "https://picsum.photos/100/100");
//	
//		Product p5 = new Product(5, "Product 5", new BigDecimal(850.50), "https://picsum.photos/100/100");
//	
//		Product p6 = new Product(6, "Product 6", new BigDecimal(950.50), "https://picsum.photos/100/100");
//
//		Product p7 = new Product(7, "Product 7", new BigDecimal(590.50), "https://picsum.photos/100/100");
//
//		Product p8 = new Product(8, "Product 8", new BigDecimal(5150.50), "https://picsum.photos/100/100");
//
//		Product p9 = new Product(9, "Product 9", new BigDecimal(1550.50), "https://picsum.photos/100/100");
//
//		Product p10 = new Product(10, "Product 10", new BigDecimal(5050.50), "https://picsum.photos/100/100");

	}

	@Override
	public Product getproductById(Integer id) {

		return products.get(id);
	}

	@Override
	public Product saveOrUpdateProduct(Product product) {
		if (product != null) {
			if (product.getId() == null) {
				product.setId(getNextKey());
			}
			products.put(product.getId(), product);

			return product;
		} else {
			throw new RuntimeException("product cont be null");
		}

	}

	private Integer getNextKey() {
		return Collections.max(products.keySet()) + 1;
	}

	@Override
	public void deleteProduct(Integer id) {
		products.remove(id);
		
	}
}
