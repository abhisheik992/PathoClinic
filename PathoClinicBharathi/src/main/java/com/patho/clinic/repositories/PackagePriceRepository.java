package com.patho.clinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patho.clinic.models.PackagePrice;

@Repository
public interface PackagePriceRepository extends JpaRepository<PackagePrice, Long> {

}
