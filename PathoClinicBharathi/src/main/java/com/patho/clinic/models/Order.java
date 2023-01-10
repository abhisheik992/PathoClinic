package com.patho.clinic.models;

import com.patho.clinic.audit.DateAudit;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order extends DateAudit{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5896437863172222855L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    
	@OneToOne
	@JoinColumn(name = "inv_id")
	private Invoice invoice;

	public Order() {
		super();
	}

	public Order(Long id, Customer customer, Invoice invoice) {
		super();
		this.id = id;
		this.customer = customer;
		this.invoice = invoice;
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

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", invoice=" + invoice + "]";
	}
	
	
}
