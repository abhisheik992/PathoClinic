package com.patho.clinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patho.clinic.models.ProductPackage;

@Repository
public interface PackageRepository extends JpaRepository<ProductPackage, Long> {

}
