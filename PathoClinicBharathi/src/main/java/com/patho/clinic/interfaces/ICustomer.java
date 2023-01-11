package com.patho.clinic.interfaces;

import java.util.List;

import com.patho.clinic.models.Address;
import com.patho.clinic.models.Customer;
import com.patho.clinic.models.CustomerReports;
import com.patho.clinic.payloads.RequestPayload;

public interface ICustomer extends ICustomerReports{
	
	public Customer addCustomer(Customer customer);

	public List<Customer> findAllCustomers();

	public List<CustomerReports>  getCustomerByIdWithReport(RequestPayload request);

	public Address addAddress(Address address);

}
