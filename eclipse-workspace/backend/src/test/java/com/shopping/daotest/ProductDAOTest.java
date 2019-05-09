package com.shopping.daotest;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.dao.ProductDAO;
import com.shopping.model.Product;

public class ProductDAOTest {
	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.shopping");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductId(27);
		product.setSupplierId(1);
		product.setCategoryId(1);
		product.setPrice(1000);
		product.setStock(19);
		product.setProductName("nikon");
		product.setProductDesc("3D");
		assertTrue("Problem in Category Insertion",productDAO.addProduct(product));
	}
	@Ignore
	@Test
	public void getProductTest()
	{
		assertNotNull("Problem in get Category",productDAO.getProduct(1));
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(26);
		assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
	}
  
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(26);
		product.setPrice(699);
		product.setStock(9);
		assertTrue("Problem in Updation",productDAO.updateProduct(product));
	}
	
	@Test
	public void listProductTest()
	{   
		List<Product> listProducts=productDAO.getProducts();
		assertNotNull("No Products",listProducts);
		
		for(Product product:listProducts)
		{
			System.out.print(product.getStock()+" ");
			System.out.print(product.getPrice()+" ");
			System.out.println(product.getProductDesc());
		}
	}
}

