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
@Table(name = "Airlines")
public class Airlines {

	@Column(name = "Airline_Code")
	private int code;

	private Set<FlightSchedules> flightSchedules = new HashSet<>();

	@OneToMany(mappedBy = "airlines", cascade = CascadeType.ALL)
	public Set<FlightSchedules> getFlightSchedules() {
		return flightSchedules;
	}

	public void setFlightSchedules(Set<FlightSchedules> flightSchedules) {
		this.flightSchedules = flightSchedules;
	}

	@Column(name = "Airline_Name")
	private String name;

	@Column(name = "Other_Details")
	private String otherDetails;

	public Airlines() {
	}

	public Airlines(String name, String otherDetails) {
		this.name = name;
		this.otherDetails = otherDetails;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

}