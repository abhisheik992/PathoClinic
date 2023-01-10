package com.patho.clinic.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Product_Package")
public class ProductPackage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Mandatory field Product Name can not be null.")
	@NotBlank(message = "Mandatory field Product Name can not be null.")
	@Column(name = "product_name")
	private String name;
	
	@Column(name = "product_desc")
	private String description;
	
	@Column(name = "product_url")
	private String image;
	
	@Column(name = "alias")
	private String alias;
	
	@Column(name = "active")
	private boolean active;

	@ManyToMany
	@JoinTable(
	  name = "Packages", 
	  joinColumns = @JoinColumn(name = "package_id"), 
	  inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> productList;

	public ProductPackage() {
		super();
	}

	public ProductPackage(Long id,
			@NotNull(message = "Mandatory field Product Name can not be null.") @NotBlank(message = "Mandatory field Product Name can not be null.") String name,
			String description, String image, String alias, boolean active, List<Product> productList) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.alias = alias;
		this.active = active;
		this.productList = productList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "ProductPackage [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image
				+ ", alias=" + alias + ", active=" + active + ", productList=" + productList + "]";
	}

}
