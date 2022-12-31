package com.patho.clinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patho.clinic.models.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

}
