package com.controller;

import org.springframework.web.bind.annotation.RestController;

import com.enitity.ProductEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ProductController 
{

	@PostMapping("/products")
	public String addproduct(@RequestBody ProductEntity productEntity) {
		
		System.out.println(productEntity.getProductName());
		return "";
	}
	
}
