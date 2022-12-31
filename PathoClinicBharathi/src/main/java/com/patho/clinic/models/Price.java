package com.patho.clinic.models;

import com.patho.clinic.audit.DateAudit;

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
@Table(name = "Price")
public class Price extends DateAudit {

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
	@JoinColumn(name = "product_id")
	private Product product;

	public Price() {
		super();
	}

	public Price(Long id, double cost, double offer, Product product) {
		super();
		this.id = id;
		this.cost = cost;
		this.offer = offer;
		this.product = product;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Price [id=" + id + ", cost=" + cost + ", offer=" + offer + ", product=" + product + "]";
	}
	
}
