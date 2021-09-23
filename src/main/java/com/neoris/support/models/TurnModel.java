package com.neoris.support.models;

import com.neoris.support.entities.TurnType;
import java.io.Serializable;
import java.util.Date;

public class TurnModel implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private int number;
    private Date turnDate;
    private String status;
    private TurnType turnType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getTurnDate() {
        return turnDate;
    }

    public void setTurnDate(Date turnDate) {
        this.turnDate = turnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TurnType getTurnType() {
        return turnType;
    }

    public void setTurnType(TurnType turnType) {
        this.turnType = turnType;
    }
}
