package com.patho.clinic.interfaces;

import java.util.List;

import com.patho.clinic.models.Price;
import com.patho.clinic.models.Product;

public interface IProduct {
	
	public Product addProduct(Product product);
	
	public Price addProductDetails(Price productDetails);

	public List<Price> getAllProducts();

}
