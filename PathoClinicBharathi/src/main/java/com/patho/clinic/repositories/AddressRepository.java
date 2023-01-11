package com.patho.clinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patho.clinic.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
