package com.patho.clinic.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patho.clinic.interfaces.IPackage;
import com.patho.clinic.models.PackagePrice;
import com.patho.clinic.models.ProductPackage;
import com.patho.clinic.payloads.RequestPayload;
import com.patho.clinic.repositories.PackagePriceRepository;
import com.patho.clinic.repositories.PackageRepository;

@Service
public class PackageService implements IPackage {

	@Autowired
	private PackageRepository packageRepository;
	
	@Autowired
	private PackagePriceRepository packagePriceRepository;
	
	@Override
	public ProductPackage addPackage(ProductPackage productPackage) {
		return this.packageRepository.save(productPackage);
	}

	@Override
	public ProductPackage getProductsByPackage(RequestPayload request) {
		return this.packageRepository.findById(request.getId()).get();
	}

	@Override
	public List<ProductPackage> findAllPackages() {
		return this.packageRepository.findAll();
	}

	@Override
	public ProductPackage addProductToPackage(ProductPackage productPackage) {
		if(this.packageRepository.existsById(productPackage.getId())) {
			ProductPackage pack = this.packageRepository.findById(productPackage.getId()).get();
			pack.setProductList(Stream.concat(pack.getProductList().stream(), productPackage.getProductList().stream())
                    .collect(Collectors.toList()));
			this.packageRepository.save(pack);
		}
		return this.packageRepository.findById(productPackage.getId()).get();
	}

	@Override
	public PackagePrice addProductDetails(PackagePrice packageDetails) {
		
		return this.packagePriceRepository.save(packageDetails);
	}

	@Override
	public List<PackagePrice> getAllPackages() {
		return this.packagePriceRepository.findAll();
	}

}
