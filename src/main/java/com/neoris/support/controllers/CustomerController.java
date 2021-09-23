/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neoris.support.controllers;

import com.neoris.support.entities.Customer;
import com.neoris.support.entities.Turn;
import com.neoris.support.entities.TypeCustomer;
import com.neoris.support.models.TurnModel;
import com.neoris.support.repositories.CustomerRepository;
import com.neoris.support.repositories.TurnRepository;
import com.neoris.support.repositories.TypeCustomerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author carlos.arodriguez
 */
@Controller
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private TypeCustomerRepository typeCustomerRepository;
    
    @Autowired
    private TurnRepository turnRepository;
    
    public Customer createCustomer(Customer customer, Integer idTypeCustomer){
        customer.setTypeCustomerId(this.typeCustomerRepository.findById(idTypeCustomer).orElse(this.typeCustomerRepository.findById(4).orElse(null)));
        if(this.typeCustomerRepository.typeCustomerMatch(customer.getTypeCustomerId().getDescription())>0){
           return this.customerRepository.save(customer);
        }
        else{
            return null;
        }
    }

    public Map getCustomerAndTurnsByDocumentNumber(String documentNumber){
        Map map = new HashMap<String,Object>();
        List<TurnModel> turns = new ArrayList();
        List<Turn> turnsDB = turnRepository.findTurnsByDocumentNumber(documentNumber);
        if(!turnsDB.isEmpty()){
            for (Turn t: turnsDB) {
                TurnModel tm = new TurnModel();
                tm.setNumber(t.getNumber());
                tm.setStatus(t.getStatus());
                tm.setId(t.getId());
                tm.setTurnDate(t.getTurnDate());
                tm.setTurnType(t.getTurnTypeId());
                turns.add(tm);
            }
        }
        map.put("customer",this.customerRepository.findCustomerByDocumentNumber(documentNumber).orElse(null));
        map.put("turns",turns);
        return map;

    }
    
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    
    public List<Turn> getTurnHistoryByCustomer(Customer customer){
        return this.turnRepository.findByCustomer(customer);
    }

    public List<TypeCustomer> getAllCustomerTypes(){
        return this.typeCustomerRepository.findAll();
    }
    
}
