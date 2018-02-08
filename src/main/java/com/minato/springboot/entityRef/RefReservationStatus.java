package com.minato.springboot.entityRef;

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

import com.minato.springboot.entity.Reservations;

/**
 * @author Minato
 *
 */
@Entity
@Table(name = "Ref_Reservation_Status")
public class RefReservationStatus {

	@Column(name = "Reservatrion_Status_Code")
	private int code;

	@Column(name = "Reservatrion_Status_Description")
	private String reservatrionStatusDesciption; // eg Boarding Pass Printed.

	private Set<Reservations> reservations = new HashSet<>();

	@OneToMany(mappedBy = "refReservationStatus", cascade = CascadeType.ALL)
	public Set<Reservations> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservations> reservations) {
		this.reservations = reservations;
	}

	public RefReservationStatus() {
	}

	public RefReservationStatus(String reservatrionStatusDesciption) {
		this.reservatrionStatusDesciption = reservatrionStatusDesciption;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getReservatrionStatusDesciption() {
		return reservatrionStatusDesciption;
	}

	public void setReservatrionStatusDesciption(String reservatrionStatusDesciption) {
		this.reservatrionStatusDesciption = reservatrionStatusDesciption;
	}
}