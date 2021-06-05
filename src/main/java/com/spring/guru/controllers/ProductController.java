package com.spring.guru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.guru.domain.Product;
import com.spring.guru.services.ProductService;

@Controller
public class ProductController {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("/products")
	public String listProducts(Model model) {
		System.out.println("############# " + productService.listAllProducts());
		model.addAttribute("products", productService.listAllProducts());

		return "products";
	}
	
	@RequestMapping("/product/{id}")
	public String getProduct(@PathVariable Integer id,Model model) {
		
		model.addAttribute("product",productService.getproductById(id));
		
		return "product";
		
	}
	
	@RequestMapping("/product/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		return "productform";
	}
	
	@RequestMapping(value="/product",method = RequestMethod.POST)
	public String saveOrUpdateProduct(Product product) {
		Product savedproduct = productService.saveOrUpdateProduct(product);
		System.out.println("$$$$$ product added successfully ");
		return "redirect:/product/"+savedproduct.getId();
		
	}
	
	@RequestMapping("/product/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		
		model.addAttribute("product",productService.getproductById(id));
		return "productform";
		
	}
	
	@RequestMapping("/product/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return "redirect:/products";
	}
	
}
