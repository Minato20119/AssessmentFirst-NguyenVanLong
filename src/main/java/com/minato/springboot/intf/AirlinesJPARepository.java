/**
 * 
 */
package com.minato.springboot.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minato.springboot.entity.Airlines;

/**
 * @author Minato
 *
 */
@Repository
public interface AirlinesJPARepository extends JpaRepository<Airlines, Integer>{

}
