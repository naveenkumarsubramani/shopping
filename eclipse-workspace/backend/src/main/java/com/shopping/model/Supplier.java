package com.shopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Supplier {
	@Id
	@GeneratedValue
	private int supplierId;
	private String supplierName;
	private String supplierAddress;
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

}


