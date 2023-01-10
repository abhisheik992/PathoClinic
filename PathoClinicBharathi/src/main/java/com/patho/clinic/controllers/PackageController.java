package com.patho.clinic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patho.clinic.interfaces.IPackage;
import com.patho.clinic.models.PackagePrice;
import com.patho.clinic.models.ProductPackage;
import com.patho.clinic.payloads.RequestPayload;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class PackageController {
	
	@Autowired
	private IPackage packageService;
	
	@PostMapping("/package")
	public ResponseEntity<ProductPackage> createPackage(@RequestBody ProductPackage productPackage) {
		ProductPackage _package = packageService.addPackage(productPackage);
		return new ResponseEntity<>(_package, HttpStatus.CREATED);
	}
	
	@PostMapping("/packageDetails")
	public ResponseEntity<ProductPackage> getProductsByPackage(@RequestBody RequestPayload request) {
		ProductPackage  _productPackage = packageService.getProductsByPackage(request);
		return new ResponseEntity<>(_productPackage, HttpStatus.CREATED);
	}
	
	@GetMapping("/packages")
    public List<ProductPackage> findAllPackages(){
        return packageService.findAllPackages();
    }
	
	@PostMapping("/addProductToPackage")
	public ResponseEntity<ProductPackage> addProductToPackage(@RequestBody ProductPackage productPackage) {
		ProductPackage  _productPackage = packageService.addProductToPackage(productPackage);
		return new ResponseEntity<>(_productPackage, HttpStatus.CREATED);
	}
	
	@PostMapping("/packagePriceDetails")
	public ResponseEntity<PackagePrice> createProductDetails(@RequestBody PackagePrice packageDetails) {
		PackagePrice _price = packageService.addProductDetails(packageDetails);
		return new ResponseEntity<>(_price, HttpStatus.CREATED);
	}
	
	@GetMapping("/packages")
	public ResponseEntity<List<PackagePrice>> getAllPackages() {
		List<PackagePrice> _packagesList = this.packageService.getAllPackages();
		return new ResponseEntity<>(_packagesList, HttpStatus.CREATED);
	}

}
