package com.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.domain.objects.Product;
import com.product.repository.ProductRepository;

@Transactional
@Component
public class ProductDaoImpl {
	
	@Autowired
	ProductRepository productRepo;

	public List<Product> getAllProducts()
	{
		return productRepo.findAll();
	}
	
	public Product getProductById(long productId)
	{
		Product product = productRepo.findById(productId).orElse(null);
		return product;
	}
	
	public void deleteProduct(long productId)
	{
		productRepo.delete(getProductById(productId));
	}
	
	public Product insertProduct(Product product)
	{
		return productRepo.save(product);
	}
	
	public Product updateProduct(Product product)
	{
		Product dbProduct = productRepo.findById(product.getProductId()).orElse(null);
        if(product.getProductName() != null)
            dbProduct.setProductName(product.getProductName());
        if(product.getProductDesc() != null)
            dbProduct.setProductDesc(product.getProductDesc());
        
        productRepo.save(dbProduct);
        //productRepo.flush();
        return dbProduct;
        
	}
	
}
