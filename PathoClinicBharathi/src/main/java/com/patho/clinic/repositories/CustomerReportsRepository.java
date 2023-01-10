package com.patho.clinic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patho.clinic.models.CustomerReports;

@Repository
public interface CustomerReportsRepository extends JpaRepository<CustomerReports, Long> {

	List<CustomerReports> findByCustomerId(Long id);

}
