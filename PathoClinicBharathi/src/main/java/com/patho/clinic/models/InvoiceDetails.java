package com.patho.clinic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Invoice_Details")
public class InvoiceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@JoinColumn(name = "invoice_id", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Invoice invoice;
	
	@JoinColumn(name = "product_id", nullable = true)
	@ManyToOne
	private Price product;
	
	@JoinColumn(name = "package_id", nullable = true)
	@ManyToOne
	private PackagePrice productPackage;
	
    @Column(name="unit")
	private int unit;
    
    @Column(name="price")
	private double price;

	public InvoiceDetails() {
		super();
	}

	public InvoiceDetails(Long id, Invoice invoice, Price product, PackagePrice productPackage, int unit,
			double price) {
		super();
		this.id = id;
		this.invoice = invoice;
		this.product = product;
		this.productPackage = productPackage;
		this.unit = unit;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Price getProduct() {
		return product;
	}

	public void setProduct(Price product) {
		this.product = product;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public PackagePrice getProductPackage() {
		return productPackage;
	}

	public void setProductPackage(PackagePrice productPackage) {
		this.productPackage = productPackage;
	}

	@Override
	public String toString() {
		return "InvoiceDetails [id=" + id + ", invoice=" + invoice + ", product=" + product + ", productPackage="
				+ productPackage + ", unit=" + unit + ", price=" + price + "]";
	}
	    
}
