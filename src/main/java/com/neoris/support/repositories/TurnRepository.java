/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neoris.support.repositories;

import com.neoris.support.entities.Customer;
import com.neoris.support.entities.Turn;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.neoris.support.entities.TurnType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author carlos.arodriguez
 */
public interface TurnRepository extends JpaRepository< Turn,Integer>{
    @Query("select t from Turn t where t.customerId = ?1")
    public List<Turn> findByCustomer(Customer customer);

    @Query("Select t from Turn t where t.turnDate=?1 and t.turnTypeId = ?2 order by t.number")
    public List<Turn> findTurnsTodayPerType (Date date, TurnType turnType);

    @Query("Select t from Turn t where t.number = ?1 and t.customerId.documentNumber = ?2")
    public Optional<Turn> findTurnPerDocumentCustomer(Integer number, String customerDocument);
}
