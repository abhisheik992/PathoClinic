package com.patho.clinic.models;

import com.patho.clinic.audit.DateAudit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer_Reports")
public class CustomerReports extends DateAudit{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4394436552673458039L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	@ManyToOne
	private Customer customer;
	
	@Column(name = "report_url")
	private String image;

	public CustomerReports() {
		super();
	}

	public CustomerReports(Long id, Customer customer, String image) {
		super();
		this.id = id;
		this.customer = customer;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "CustomerReports [id=" + id + ", customer=" + customer + ", image=" + image + "]";
	}
		
}
