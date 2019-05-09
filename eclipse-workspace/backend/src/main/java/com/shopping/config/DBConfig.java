package com.shopping.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shopping.dao.CartDAO;
import com.shopping.dao.CartDAOImpl;
import com.shopping.dao.CategoryDAO;
import com.shopping.dao.CategoryDAOImpl;
import com.shopping.dao.ProductDAO;
import com.shopping.dao.ProductDAOImpl;
import com.shopping.dao.SupplierDAO;
import com.shopping.dao.SupplierDAOImpl;
import com.shopping.model.Cart;
import com.shopping.model.Category;
import com.shopping.model.Product;
import com.shopping.model.Supplier;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.shopping.*")
public class DBConfig 
{
@Bean(name="datasource")
public DataSource getH2DataSource()
{
	DriverManagerDataSource datasource=new DriverManagerDataSource();
	
	datasource.setDriverClassName("org.h2.Driver");
	datasource.setUrl("jdbc:h2:tcp://localhost/E:/database/table1/shop");
	datasource.setUsername("nav");
	datasource.setPassword("nav");
	System.out.println(">>>>>>Datasource object created<<<<<<");
	return datasource;
}

@Bean(name="sessionFactory")
public SessionFactory getSessionFactory()
{
	Properties hibernateprop=new Properties();
	
	hibernateprop.put("hibernate.hbm2ddl.auto","update");
	hibernateprop.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());

	factory.addProperties(hibernateprop);
	
	factory.addAnnotatedClass(Category.class);
	factory.addAnnotatedClass(Supplier.class);
	factory.addAnnotatedClass(Product.class);
	
	System.out.println(">>>>>>SessionFactory Object created<<<<<<");

	return factory.buildSessionFactory();
	
}
@Bean(name="TransactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
	System.out.println(">>>>>TransactionManager Object created<<<<<<");
	return new HibernateTransactionManager(sessionFactory);
}
@Bean(name="categoryDAO") 
		public CategoryDAO getCategoryDAO() {
	System.out.println("Category DAO Implementation");
			return new CategoryDAOImpl();
		}
@Bean(name="supplierDAO") 
public SupplierDAO getSupplierDAO() {
	System.out.println("Supplier DAO Implementation");
	return new SupplierDAOImpl();
}@Bean(name="productDAO") 
public ProductDAO getProductDAO() {
	System.out.println("Product DAO Implementation");
	return new ProductDAOImpl();
}}

