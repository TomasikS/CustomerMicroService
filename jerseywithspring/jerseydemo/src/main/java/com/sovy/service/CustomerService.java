/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sovy.service;

import com.sovy.repository.CustomerRepository;
import com.sovy.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author stefan.tomasik
 */
@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public Customer createCustomer(Customer entity) {
        Customer newEntity = repository.save(entity);
        return newEntity;
    }

    public void updateCustomer(Customer entity) {
        Customer customer = repository.findOne(entity.getId());
        repository.save(customer);
    }
    
    public Customer getCustomer(Long id) {
        Customer customer = repository.findOne(id);
         return customer;
    }
    
    public void deleteCustomer(Long id)
    {
     Customer customer = repository.findOne(id);
     repository.delete(customer);
    
    }

}
