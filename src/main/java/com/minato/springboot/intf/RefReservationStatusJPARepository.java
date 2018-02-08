/**
 * 
 */
package com.minato.springboot.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minato.springboot.entityRef.RefReservationStatus;

/**
 * @author Minato
 *
 */
@Repository
public interface RefReservationStatusJPARepository extends JpaRepository<RefReservationStatus, Integer>{

}
