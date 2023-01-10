package com.patho.clinic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patho.clinic.interfaces.ICustomer;
import com.patho.clinic.models.Customer;
import com.patho.clinic.models.CustomerReports;
import com.patho.clinic.payloads.RequestPayload;
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

	@Override
	public List<Customer> findAllCustomers() {
		return this.customerRepository.findAll();
	}

	@Override
	public List<CustomerReports>  getCustomerByIdWithReport(RequestPayload request) {

		if(this.customerRepository.existsById(request.getId())) {
			List<CustomerReports> customerDetails = this.customerReportsRepository.findByCustomerId(request.getId());
			return customerDetails;
		}
		return null;
	}

}
