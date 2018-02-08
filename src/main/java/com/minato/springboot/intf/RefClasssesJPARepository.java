/**
 * 
 */
package com.minato.springboot.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minato.springboot.entityRef.RefClasses;

/**
 * @author Minato
 *
 */
@Repository
public interface RefClasssesJPARepository extends JpaRepository<RefClasses, Integer>{

}
