package com.minato.springboot.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Minato
 *
 */
@Entity
@Table(name = "Customers")
public class Customers {

	@Column(name = "Customer_ID")
	private int id;

	@Column(name = "Customer_Name")
	private String customerName;

	@Column(name = "Other_Details")
	private String otherDetails;

	private Set<Reservations> reservations = new HashSet<>();

	public Customers() {
	}

	public Customers(String customerName, String otherDetails) {
		this.customerName = customerName;
		this.otherDetails = otherDetails;
	}

	@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
	public Set<Reservations> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservations> reservations) {
		this.reservations = reservations;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

}