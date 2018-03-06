package com.product.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.domain.objects.Product;
import com.product.repository.ProductRepository;

@Repository
@Transactional
public class ProductDaoImpl {
	
	@Autowired
	ProductRepository productRepo;
	
	List<Product> allProducts = new ArrayList<Product>(); 

	public Product getProductById(long productId)
	{
		ProductDaoImpl.class.getAnnotatedInterfaces();
		Product product = productRepo.getOne(productId);
		return product;
	}
	
	public void deleteProduct(long productId)
	{
		productRepo.delete(getProductById(productId));
	}
	
	public void insertProduct(Product product)
	{
		productRepo.save(product);
	}
	
	public Product updateProduct(Product product)
	{
		productRepo.flush();
		return product;
	}
	
	public List<Product> getAllProducts()
	{
		allProducts = productRepo.findAll();
		return allProducts;
	}
	
}
