package com.patho.clinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patho.clinic.models.InvoiceDetails;

@Repository
public interface InvoiceDetailRepositiry extends JpaRepository<InvoiceDetails, Long> {

}
