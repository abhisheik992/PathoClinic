package com.patho.clinic.models;

import java.util.List;

import com.patho.clinic.audit.DateAudit;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Invoice")
public class Invoice extends DateAudit{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7556185236718458873L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceDetails> invoiceDetailsList;

    @Column(name = "comment", length = 150)
    private String comment;
    
    @Column(name="total")
    private double total;
    
    @Column(name="status")
    private int status;

	public Invoice() {
		super();
	}

	public Invoice(Long id, Customer customer, List<InvoiceDetails> invoiceDetailsList, String comment, double total,
			int status) {
		super();
		this.id = id;
		this.customer = customer;
		this.invoiceDetailsList = invoiceDetailsList;
		this.comment = comment;
		this.total = total;
		this.status = status;
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

	public List<InvoiceDetails> getInvoiceDetailsList() {
		return invoiceDetailsList;
	}

	public void setInvoiceDetailsList(List<InvoiceDetails> invoiceDetailsList) {
		this.invoiceDetailsList = invoiceDetailsList;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", customer=" + customer + ", invoiceDetailsList=" + invoiceDetailsList
				+ ", comment=" + comment + ", total=" + total + ", status=" + status + "]";
	}

	
}
