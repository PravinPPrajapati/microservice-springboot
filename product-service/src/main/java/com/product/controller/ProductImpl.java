package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.domain.objects.Product;
import com.product.dao.ProductDaoImpl;

@RestController
@RequestMapping("/product")
public class ProductImpl {
	@Autowired
	private ProductDaoImpl productDao = null;
	List<Product> allProducts = null;

	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProduct()
	{
		allProducts = productDao.getAllProducts();
		return allProducts;
	}
	
	@GetMapping(value="/{productId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Product getProductById(@PathVariable("productId") long productId)
	{
		Product product = productDao.getProductById(productId);
		System.out.println(product.getProductName());
		return product;
	}
	
	@PostMapping(value="/insert",produces= MediaType.APPLICATION_JSON_VALUE)
	public void insertProduct(@RequestBody Product product)
	{
		productDao.insertProduct(product);
	}
	
	@DeleteMapping(value="/delete/{productId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public void deleteProductById(@PathVariable("productId") long productId)
	{
		productDao.deleteProduct(productId);
	}
	
	@PostMapping(value="/update/{productId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public void updateProduct(@RequestBody Product product, @PathVariable("productId") long productId)
	{
		product.setProductId(productId);
		productDao.updateProduct(product);
	}

}
