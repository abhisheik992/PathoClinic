package com.patho.clinic.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Package_Price")
public class PackagePrice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5794693362177354062L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "product_cost")
	private double cost;
	
	@Column(name = "product_offer")
	private double offer;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "package_id")
	private ProductPackage productPackage;

	public PackagePrice() {
		super();
	}

	public PackagePrice(Long id, double cost, double offer, ProductPackage productPackage) {
		super();
		this.id = id;
		this.cost = cost;
		this.offer = offer;
		this.productPackage = productPackage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getOffer() {
		return offer;
	}

	public void setOffer(double offer) {
		this.offer = offer;
	}

	public ProductPackage getProductPackage() {
		return productPackage;
	}

	public void setProductPackage(ProductPackage productPackage) {
		this.productPackage = productPackage;
	}

	@Override
	public String toString() {
		return "Price [id=" + id + ", cost=" + cost + ", offer=" + offer + ", productPackage=" + productPackage + "]";
	}
	
}
