/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sovy.repository;

import com.sovy.model.Customer;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author stefan.tomasik
 */
@Transactional
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
