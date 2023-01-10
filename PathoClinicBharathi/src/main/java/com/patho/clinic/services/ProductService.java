package com.patho.clinic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patho.clinic.interfaces.IProduct;
import com.patho.clinic.models.Price;
import com.patho.clinic.models.Product;
import com.patho.clinic.repositories.PriceRepository;
import com.patho.clinic.repositories.ProductRepository;

@Service
public class ProductService implements IProduct{
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private PriceRepository priceRepository;

	@Override
	public Product addProduct(Product product) {
		return this.productRepo.save(product);
	}
	
	@Override
	public Price addProductDetails(Price productDetails) {
		return this.priceRepository.save(productDetails);
	}

	@Override
	public List<Price> getAllProducts() {
		return this.priceRepository.findAll();
	}

}
