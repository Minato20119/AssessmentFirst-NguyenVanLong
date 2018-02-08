/**
 * 
 */
package com.minato.springboot.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minato.springboot.entity.FlightSchedules;

/**
 * @author Minato
 *
 */
@Repository
public interface FlightSchedulesJPARepository extends JpaRepository<FlightSchedules, Integer>{

}
