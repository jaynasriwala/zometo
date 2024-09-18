package com.controller;

import org.springframework.web.bind.annotation.RestController;

import com.enitity.ProductEntity;
import com.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.hibernate.grammars.hql.HqlParser.IsEmptyPredicateContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ProductController 
{

	@Autowired
	ProductRepository productrepository;
	
	@PostMapping("/products")
	public ProductEntity addproduct(@RequestBody ProductEntity productEntity) {
		
		System.out.println(productEntity.getProductName());
		
		productrepository.save(productEntity);
		return productEntity;
	}
	
	@GetMapping("/products")
	public List<ProductEntity> getProduct()
	{
		return productrepository.findAll();
	}
	
	@GetMapping("/products/{productId}")
	public ProductEntity getProductById(@PathVariable("productId") Integer productId)
	{
		
		Optional<ProductEntity> op =  productrepository.findById(productId);
		
		if (op.isEmpty())
		{
			return null;
		}
		else
		{
		
			return op.get();
		}
	}
	
//	@GetMapping("/productsbyid")
//	public ProductEntity getProductById2(@RequestParam("productId") Integer productId) {
//		Optional<ProductEntity> op = productRepository.findById(productId);
//		if (op.isEmpty()) {
//			return null;
//		} else {
//			ProductEntity productEntity = op.get();
//			return productEntity;
//		}
//	}
}
