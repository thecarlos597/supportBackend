package com.neoris.support.models;

import com.neoris.support.entities.Customer;
import com.neoris.support.entities.TurnType;

public class CreateTurnModel {
    private Customer customer;
    private TurnType turnType;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TurnType getTurnType() {
        return turnType;
    }

    public void setTurnType(TurnType turnType) {
        this.turnType = turnType;
    }
}
