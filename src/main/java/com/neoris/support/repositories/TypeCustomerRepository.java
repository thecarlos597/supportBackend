/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neoris.support.repositories;

import com.neoris.support.entities.TypeCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author carlos.arodriguez
 */
public interface TypeCustomerRepository extends JpaRepository<TypeCustomer,Integer>{
    
    @Query("Select count(tc) from TypeCustomer tc where tc.description =?1 ")
    public Integer typeCustomerMatch(String desc);
    
}
