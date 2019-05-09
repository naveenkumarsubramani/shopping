package com.shopping.dao;

import java.util.List;

import com.shopping.model.Product;

public interface ProductDAO {
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	public List<Product> getProducts();
    public Product getProduct(int productId);
}


