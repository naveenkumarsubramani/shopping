package com.shopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.apache.commons.fileupload.MultipartStream;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Product {
	@Id
	@GeneratedValue
private int productId;
private String productName;
private String productDesc;
private int categoryId;
private int supplierId;
private double price;
private int stock;
@Transient 
private MultipartStream pimage;
public MultipartStream getPimage() {
	return pimage;
}
public void setPimage(MultipartStream pimage) {
	this.pimage = pimage;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductDesc() {
	return productDesc;
}
public void setProductDesc(String productDesc) {
	this.productDesc = productDesc;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public int getSupplierId() {
	return supplierId;
}
public void setSupplierId(int supplierId) {
	this.supplierId = supplierId;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
}


