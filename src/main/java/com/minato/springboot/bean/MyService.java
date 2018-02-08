/**
 * 
 */
package com.minato.springboot.bean;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minato.springboot.entity.Airlines;
import com.minato.springboot.entity.FlightSchedules;
import com.minato.springboot.entity.Reservations;
import com.minato.springboot.intf.AirlinesJPARepository;
import com.minato.springboot.intf.FlightSchedulesJPARepository;
import com.minato.springboot.intf.ReservationsJPARepository;

/**
 * @author Minato
 *
 */
@Service
public class MyService {

	@Autowired
	private AirlinesJPARepository airlinesJPARepository;

	@Autowired
	private ReservationsJPARepository reservationsJPARepository;

	@Autowired
	private FlightSchedulesJPARepository flightSchedulesJPARepository;

	private static final Logger LOG = LoggerFactory.getLogger(MyService.class);
	
	public Airlines update(int id, String name) {
		Airlines newAirlines = airlinesJPARepository.findOne(id);
		newAirlines.setName(name);
		return newAirlines;
	}

	public void removeFlightSchedules(int id) {
		// Remove reservations.
		// Bởi vì bảng này chứa khóa ngoại (Schedule_ID) của bảng FlightSchedules.
		// Xóa Reservation trước, sau đó mới xóa được FlightSchedules.
		// Tự tăng id cùng nhau, nên id của Reservation = id của Flight Schedules.
		Reservations r1 = reservationsJPARepository.findOne(id);
		reservationsJPARepository.delete(r1);

		// Remove FlightSchedules
		FlightSchedules f1 = flightSchedulesJPARepository.findOne(id);
		flightSchedulesJPARepository.delete(f1);

		LOG.info("Done Delete FlightSchedules with id = 3.");
	}

	public void insertFlightSchedules(int id, int flightNumber, Date departureTime, Date arrivalTime,
			String otherDetails) {
		FlightSchedules insertFlightSchedules = new FlightSchedules();
		insertFlightSchedules.setId(id);
		insertFlightSchedules.setFlightNumber(flightNumber);
		insertFlightSchedules.setDepartureTime(departureTime);
		insertFlightSchedules.setArrivalTime(arrivalTime);
		insertFlightSchedules.setOtherDetails(otherDetails);

		flightSchedulesJPARepository.save(insertFlightSchedules);
	}
	
}
