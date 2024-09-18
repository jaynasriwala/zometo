package com.controller;

import org.springframework.web.bind.annotation.RestController;

import com.enitity.ProductEntity;
import com.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ProductController 
{

	@Autowired
	ProductRepository productrepository;
	
	@PostMapping("/products")
	public String addproduct(@RequestBody ProductEntity productEntity) {
		
		System.out.println(productEntity.getProductName());
		
		productrepository.save(productEntity);
		return "success";
	}
	
}
