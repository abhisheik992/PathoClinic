package com.patho.clinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patho.clinic.interfaces.ICustomer;
import com.patho.clinic.models.Customer;
import com.patho.clinic.models.CustomerReports;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	private ICustomer customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer _customer = customerService.addCustomer(customer);
		return new ResponseEntity<>(_customer, HttpStatus.CREATED);
	}
	
	@PostMapping("/customerReport")
	public ResponseEntity<CustomerReports> createCustomerReport(@RequestBody CustomerReports report) {
		CustomerReports _customerReport = customerService.addCustomerReport(report);
		return new ResponseEntity<>(_customerReport, HttpStatus.CREATED);
	}

}
