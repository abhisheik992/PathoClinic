package com.patho.clinic.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Mandatory field Customer Name can not be null.")
	@NotBlank(message = "Mandatory field Customer Name can not be Blank.")
	@Column(name = "customer_name")
	private String name;
	
	@Column(name = "customer_email")
	private String email;
	
	@Column(name = "customer_mobile")
	private String mobile;
	
	@Column(name = "customer_age")
	private int age;
	
//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    private List<CustomerReports> customerReportsList;

	public Customer() {
		super();
	}

	public Customer(Long id, String name, String email, String mobile, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.age = age;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public List<CustomerReports> getCustomerReportsList() {
		return customerReportsList;
	}

	public void setCustomerReportsList(List<CustomerReports> customerReportsList) {
		this.customerReportsList = customerReportsList;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", age=" + age
				+ "]";
	}
	
}
