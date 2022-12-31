package com.patho.clinic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patho.clinic.interfaces.ICustomer;
import com.patho.clinic.models.Customer;
import com.patho.clinic.models.CustomerReports;
import com.patho.clinic.repositories.CustomerReportsRepository;
import com.patho.clinic.repositories.CustomerRepository;

@Service
public class CustomerService implements ICustomer {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerReportsRepository customerReportsRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public CustomerReports addCustomerReport(CustomerReports report) {
		return this.customerReportsRepository.save(report);
	}

}
