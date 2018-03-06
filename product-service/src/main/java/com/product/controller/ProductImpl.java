package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.objects.Product;
import com.product.dao.ProductDaoImpl;

@RestController
@RequestMapping("/product")
public class ProductImpl {
	@Autowired
	private ProductDaoImpl productDao = null;
	List<Product> allProducts = null;

	@GetMapping(value="/",produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProduct()
	{
		allProducts = productDao.getAllProducts();
		return allProducts;
	}
	
	
	
	

}
