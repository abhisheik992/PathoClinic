package com.patho.clinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patho.clinic.models.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
