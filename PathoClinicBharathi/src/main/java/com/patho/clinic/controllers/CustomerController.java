package com.patho.clinic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patho.clinic.interfaces.ICustomer;
import com.patho.clinic.models.Address;
import com.patho.clinic.models.Customer;
import com.patho.clinic.models.CustomerReports;
import com.patho.clinic.payloads.RequestPayload;

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
	
	@GetMapping("/customers")
    public List<Customer> findAllCustomers(){
        return customerService.findAllCustomers();
    }
	
	@PostMapping("/customerDetails")
	public ResponseEntity<List<CustomerReports> > getCustomerByIdWithReport(@RequestBody RequestPayload request) {
		List<CustomerReports>  _customerDetails = customerService.getCustomerByIdWithReport(request);
		return new ResponseEntity<>(_customerDetails, HttpStatus.CREATED);
	}
	
	@PostMapping("/address")
	public ResponseEntity<Address> createAddress(@RequestBody Address address) {
		Address _address = customerService.addAddress(address);
		return new ResponseEntity<>(_address, HttpStatus.CREATED);
	} 

}
