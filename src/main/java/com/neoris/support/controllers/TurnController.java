/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neoris.support.controllers;

import com.neoris.support.entities.Customer;
import com.neoris.support.entities.Turn;
import com.neoris.support.entities.TurnType;
import com.neoris.support.exceptions.CreateTurnException;
import com.neoris.support.repositories.CustomerRepository;
import com.neoris.support.repositories.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Date;
import java.util.List;

/**
 *
 * @author carlos.arodriguez
 */
@Controller
public class TurnController {
    @Autowired
    private TurnRepository turnRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Turn createTurn(String document) throws CreateTurnException {
        Customer customer = this.customerRepository.findCustomerByDocumentNumber(document).orElse(null);
        if(customer == null) {
            throw new CreateTurnException("No se pudo crear el turno, el cliente no existe.");
        }
        List<Turn> turnFilterList = this.turnRepository.findTurnsTodayPerType(new Date(),customer.getTypeCustomerId().getTurnTypeId());
        Turn turn = new Turn();
        if(turnFilterList.isEmpty()){
            turn.setNumber(1);
            turn.setTurnDate(new Date());
            turn.setStatus("pending");
            turn.setCustomerId(customer);
            turn.setTurnTypeId(customer.getTypeCustomerId().getTurnTypeId());
        }
        else{
            turn.setNumber(turnFilterList.get(turnFilterList.size()-1).getNumber()+1);
            turn.setTurnDate(new Date());
            turn.setStatus("pending");
            turn.setCustomerId(customer);
            turn.setTurnTypeId(customer.getTypeCustomerId().getTurnTypeId());
        }
        this.turnRepository.save(turn);
        return turn;
    }

    public String changeTurnStatus(Integer numberTurn,String customerDocumentNumber) throws CreateTurnException{
        Turn turnFilter = turnRepository.findTurnPerDocumentCustomer(numberTurn,customerDocumentNumber).orElse(null);
        if(turnFilter==null){
            throw new CreateTurnException("No se encontro al cliente");
        }
        turnFilter.setStatus("done");
        return this.turnRepository.save(turnFilter).getStatus();
    }

    public List<Turn> findTurnsPerDayAndType(Date date,TurnType turnType){
        return this.turnRepository.findTurnsTodayPerType(date,turnType);
    }


}
