package com.shopping.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.dao.CategoryDAO;
import com.shopping.model.Category;

public class CategoryDAOTest {
	static CategoryDAO categoryDAO;
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.shopping");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	public void addcategorytest() {
		Category category=new Category();
		category.setCategoryName("Digital camera");
		category.setCategoryDesc("nikon");
		assertTrue("problem in adding",categoryDAO.addCategory(category));
	}
	@Ignore
	@Test
	public void getCategoryTest()
	{
		assertNotNull("Problem in get Category",categoryDAO.getCategory(2));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(1);
		assertTrue("Problem in Deletion:",categoryDAO.deleteCategory(category));
	}
    
	
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		category.setCategoryName("nikon");
		assertTrue("Problem in Updation",categoryDAO.updateCategory(category));
	}

	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.getCategories();
		assertNotNull("No Categories",listCategories);
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+" ");
			System.out.print(category.getCategoryName()+" ");
			System.out.println(category.getCategoryDesc());
		}
	}
}


