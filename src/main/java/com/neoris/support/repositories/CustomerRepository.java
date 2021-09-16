/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neoris.support.repositories;

import com.neoris.support.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 *
 * @author carlos.arodriguez
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
    @Query("select c from Customer c where c.documentNumber = ?1")
    public Optional<Customer> findCustomerByDocumentNumber(String documentNumber);
}
