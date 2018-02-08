/**
 * 
 */
package com.minato.springboot.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import com.minato.springboot.entity.Airlines;
import com.minato.springboot.entity.Customers;
import com.minato.springboot.entity.FlightSchedules;
import com.minato.springboot.entity.Reservations;
import com.minato.springboot.entityRef.RefClasses;
import com.minato.springboot.entityRef.RefPaymentMethods;
import com.minato.springboot.entityRef.RefReservationStatus;
import com.minato.springboot.intf.AirlinesJPARepository;
import com.minato.springboot.intf.CustomersJPARepository;
import com.minato.springboot.intf.FlightSchedulesJPARepository;
import com.minato.springboot.intf.RefClasssesJPARepository;
import com.minato.springboot.intf.RefPaymentMethodsJPARepository;
import com.minato.springboot.intf.RefReservationStatusJPARepository;
import com.minato.springboot.intf.ReservationsJPARepository;

/**
 * @author Minato
 *
 */
@Repository
public class MyRepository implements CommandLineRunner {

	@Autowired
	private MyService myService;

	@Autowired
	private AirlinesJPARepository airlinesJPARepository;

	@Autowired
	private CustomersJPARepository customersJPARepository;

	@Autowired
	private RefClasssesJPARepository refClasssesJPARepository;

	@Autowired
	private ReservationsJPARepository reservationsJPARepository;

	@Autowired
	private FlightSchedulesJPARepository flightSchedulesJPARepository;

	@Autowired
	private RefPaymentMethodsJPARepository refPaymentMethodsJPARepository;

	@Autowired
	private RefReservationStatusJPARepository refReservationStatusJPARepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(MyService.class);

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		// airlinesJPARepository.deleteAllInBatch();
		// customersJPARepository.deleteAllInBatch();
		// refClasssesJPARepository.deleteAllInBatch();
		// reservationsJPARepository.deleteAllInBatch();
		// flightSchedulesJPARepository.deleteAllInBatch();
		// refPaymentMethodsJPARepository.deleteAllInBatch();
		// refReservationStatusJPARepository.deleteAllInBatch();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MM dd HH:mm:ss");

		String dateInString = "2018 10 12 12:35:00";
		Date dateDepartureVietnamAirlines = simpleDateFormat.parse(dateInString);

		dateInString = "2018 10 12 13:35:00";
		Date dateArrivalVietnamAirlines = simpleDateFormat.parse(dateInString);

		dateInString = "2018 10 12 12:40:00";
		Date dateDepartureVietnamAirlines2 = simpleDateFormat.parse(dateInString);

		dateInString = "2018 10 12 14:40:00";
		Date dateArrivalVietnamAirlines2 = simpleDateFormat.parse(dateInString);

		// Airlines
		Airlines vietnamAirlines = new Airlines("Vietnam Airlines", "This is detail of Vietnam Airlines");

		// FlightSchedules
		FlightSchedules flightSchedulesVietnamAirlines = new FlightSchedules(1, dateDepartureVietnamAirlines,
				dateArrivalVietnamAirlines, "This is flight schedules of VietName Airlines");
		flightSchedulesVietnamAirlines.setAirlines(vietnamAirlines);

		FlightSchedules flightSchedulesVietnamAirlines2 = new FlightSchedules(2, dateDepartureVietnamAirlines2,
				dateArrivalVietnamAirlines2, "This is flight schedules of VietName Airlines 2");
		flightSchedulesVietnamAirlines2.setAirlines(vietnamAirlines);

		vietnamAirlines.getFlightSchedules().add(flightSchedulesVietnamAirlines);
		vietnamAirlines.getFlightSchedules().add(flightSchedulesVietnamAirlines2);

		airlinesJPARepository.save(vietnamAirlines);

		LOG.info("Done VietNam Airline");

		// RefClasses
		RefClasses refClasses = new RefClasses("First");

		// RefPaymentMethods
		RefPaymentMethods refPaymentMethods = new RefPaymentMethods("Master Card");

		// RefReservationStatus
		RefReservationStatus refReservationStatus = new RefReservationStatus("Boarding Pass Printed");

		// Customers
		Customers customers = new Customers("Minato Customers", "This is details of Customers customers");

		// Reservations
		dateInString = "2018 12 20 17:00:00";
		Date dateReservationMade = simpleDateFormat.parse(dateInString);

		dateInString = "2018 12 20 00:00:00";
		Date dateOfFlight = simpleDateFormat.parse(dateInString);

		Reservations reservations1 = new Reservations("Minato Reservations 1", dateReservationMade, dateOfFlight, 12,
				"This is details of Reservations 1");

		Reservations reservations2 = new Reservations("Minato Reservations 2", dateReservationMade, dateOfFlight, 13,
				"This is details of Reservations 2");

		// Customers
		reservations1.setCustomers(customers);
		reservations2.setCustomers(customers);

		// RefClasses
		reservations1.setRefClasses(refClasses);
		reservations2.setRefClasses(refClasses);

		// RefPaymentMethods
		reservations1.setRefPaymentMethods(refPaymentMethods);
		reservations2.setRefPaymentMethods(refPaymentMethods);

		// RefReservationStatus
		reservations1.setRefReservationStatus(refReservationStatus);
		reservations2.setRefReservationStatus(refReservationStatus);

		// Flight Schedules
		reservations1.setFlightSchedules(flightSchedulesVietnamAirlines);
		reservations2.setFlightSchedules(flightSchedulesVietnamAirlines);

		// Get Reservations
		customers.getReservations().add(reservations1);
		customers.getReservations().add(reservations2);

		refClasses.getReservations().add(reservations1);
		refClasses.getReservations().add(reservations2);

		refPaymentMethods.getReservations().add(reservations1);
		refPaymentMethods.getReservations().add(reservations2);

		refReservationStatus.getReservations().add(reservations1);
		refReservationStatus.getReservations().add(reservations2);

		flightSchedulesVietnamAirlines.getReservations().add(reservations1);
		flightSchedulesVietnamAirlines.getReservations().add(reservations2);

		// Save Reservations
		customersJPARepository.save(customers);
		LOG.info("Save Customers");

		refClasssesJPARepository.save(refClasses);
		LOG.info("Save RefClasses");

		refPaymentMethodsJPARepository.save(refPaymentMethods);
		LOG.info("Save RefPaymentMethods");

		refReservationStatusJPARepository.save(refReservationStatus);
		LOG.info("Save RefResrvationStatus");

		flightSchedulesJPARepository.save(flightSchedulesVietnamAirlines);
		LOG.info("Save Flight Schedules");

		// Update
		Airlines newAirlines = myService.update(1, "VietJet Air");
		airlinesJPARepository.save(newAirlines);
		LOG.info("Done Update id 1 of Airlines.");

		// Count Flight Schedules
		LOG.info("Count of Flight Schedules before remove: " + flightSchedulesJPARepository.count());
		LOG.info("Count of Reservations before remove: " + reservationsJPARepository.count());

		// Delete id 1 of Flight Schedules
		if (flightSchedulesJPARepository.findOne(10) != null) {
			myService.removeFlightSchedules(10);
		} else {
			LOG.info("Khong co id 10.");
		}

		LOG.info("Count of Flight Schedules after remove: " + flightSchedulesJPARepository.count());
		LOG.info("Count of Reservations after remove: " + reservationsJPARepository.count());

		// Insert
		if (flightSchedulesJPARepository.findOne(10) == null) {
			myService.insertFlightSchedules(10, 10, dateDepartureVietnamAirlines2, dateArrivalVietnamAirlines2,
					"This is detail of Flight Schedules inserted.");
			LOG.info("Done insert Flight Schedules with id = 10.");
		} else {
			LOG.info("Id 10 da ton tai.");
		}
		LOG.info("Count of Flight Schedules after insert: " + flightSchedulesJPARepository.count());
		
		// Display Database Reservations
		for(Reservations r : reservationsJPARepository.findAll()) {
			LOG.info(r.toString());
		}
	}

}