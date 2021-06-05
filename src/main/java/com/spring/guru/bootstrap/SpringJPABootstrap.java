package com.spring.guru.bootstrap;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.spring.guru.domain.Product;
import com.spring.guru.services.ProductService;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		loadProduct();
	}
	
	public void loadProduct() {
		
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
		
		for(Product p: productList) {
			productService.saveOrUpdateProduct(p);
		}
//		productList.forEach(product->productService.saveOrUpdateProduct(product));

		
		
	}

}
