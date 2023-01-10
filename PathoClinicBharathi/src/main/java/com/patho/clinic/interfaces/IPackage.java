package com.patho.clinic.interfaces;

import java.util.List;

import com.patho.clinic.models.PackagePrice;
import com.patho.clinic.models.ProductPackage;
import com.patho.clinic.payloads.RequestPayload;

public interface IPackage {

	ProductPackage addPackage(ProductPackage productPackage);

	ProductPackage getProductsByPackage(RequestPayload request);

	List<ProductPackage> findAllPackages();

	ProductPackage addProductToPackage(ProductPackage productPackage);
	
	public PackagePrice addProductDetails(PackagePrice packageDetails);

}
