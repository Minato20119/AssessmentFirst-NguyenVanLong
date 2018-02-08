package com.minato.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.minato.springboot.entityRef.RefClasses;
import com.minato.springboot.entityRef.RefPaymentMethods;
import com.minato.springboot.entityRef.RefReservationStatus;

/**
 * @author Minato
 *
 */
@Entity
@Table(name = "Reservations")
public class Reservations {

	@Column(name = "Reservation_ID")
	private int id;

	@Column(name = "Customer_Name")
	private String customerName;

	@Column(name = "Date_Reservation_Made")
	private Date dateReservationMade;

	@Column(name = "Date_of_Flight")
	private Date dateOfFlight;

	@Column(name = "E_Ticket_Number")
	private int eTicketNumber;

	@Column(name = "Other_Details")
	private String otherDetails;

	private FlightSchedules flightSchedules;

	private Customers customers;

	private RefClasses refClasses;

	private RefPaymentMethods refPaymentMethods;

	private RefReservationStatus refReservationStatus;

	public Reservations() {
	}

	public Reservations(String customerName, Date dateReservationMade, Date dateOfFlight, int eTicketNumber,
			String otherDetails) {
		this.customerName = customerName;
		this.dateReservationMade = dateReservationMade;
		this.dateOfFlight = dateOfFlight;
		this.eTicketNumber = eTicketNumber;
		this.otherDetails = otherDetails;
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

	public Date getDateReservationMade() {
		return dateReservationMade;
	}

	public void setDateReservationMade(Date dateReservationMade) {
		this.dateReservationMade = dateReservationMade;
	}

	public Date getDateOfFlight() {
		return dateOfFlight;
	}

	public void setDateOfFlight(Date dateOfFlight) {
		this.dateOfFlight = dateOfFlight;
	}

	public int geteTicketNumber() {
		return eTicketNumber;
	}

	public void seteTicketNumber(int eTicketNumber) {
		this.eTicketNumber = eTicketNumber;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	@ManyToOne
	@JoinColumn(name = "Schedule_ID")
	public FlightSchedules getFlightSchedules() {
		return flightSchedules;
	}

	public void setFlightSchedules(FlightSchedules flightSchedules) {
		this.flightSchedules = flightSchedules;
	}

	@ManyToOne
	@JoinColumn(name = "Customer_ID")
	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	@ManyToOne
	@JoinColumn(name = "Class_Number")
	public RefClasses getRefClasses() {
		return refClasses;
	}

	public void setRefClasses(RefClasses refClasses) {
		this.refClasses = refClasses;
	}

	@ManyToOne
	@JoinColumn(name = "Payment_Method_Code")
	public RefPaymentMethods getRefPaymentMethods() {
		return refPaymentMethods;
	}

	public void setRefPaymentMethods(RefPaymentMethods refPaymentMethods) {
		this.refPaymentMethods = refPaymentMethods;
	}

	@ManyToOne
	@JoinColumn(name = "Reservatrion_Status_Code")
	public RefReservationStatus getRefReservationStatus() {
		return refReservationStatus;
	}

	public void setRefReservationStatus(RefReservationStatus refReservationStatus) {
		this.refReservationStatus = refReservationStatus;
	}

	@Override
	public String toString() {
		return "Reservations [id=" + id + ", customerName=" + customerName + ", dateReservationMade="
				+ dateReservationMade + ", dateOfFlight=" + dateOfFlight + ", eTicketNumber=" + eTicketNumber
				+ ", otherDetails=" + otherDetails + ", flightSchedules=" + flightSchedules + ", customers=" + customers
				+ ", refClasses=" + refClasses + ", refPaymentMethods=" + refPaymentMethods + ", refReservationStatus="
				+ refReservationStatus + "]";
	}

}