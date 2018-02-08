/**
 * 
 */
package com.minato.springboot.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minato.springboot.entity.Customers;

/**
 * @author Minato
 *
 */
@Repository
public interface CustomersJPARepository extends JpaRepository<Customers, Integer>{

}
