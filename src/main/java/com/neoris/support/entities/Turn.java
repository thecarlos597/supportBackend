/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neoris.support.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlos.arodriguez
 */
@Entity
@Table(name = "turn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turn.findAll", query = "SELECT t FROM Turn t"),
    @NamedQuery(name = "Turn.findById", query = "SELECT t FROM Turn t WHERE t.id = :id"),
    @NamedQuery(name = "Turn.findByNumber", query = "SELECT t FROM Turn t WHERE t.number = :number"),
    @NamedQuery(name = "Turn.findByTurnDate", query = "SELECT t FROM Turn t WHERE t.turnDate = :turnDate")})
public class Turn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "number")
    private int number;
    @Column(name = "turn_date")
    @Temporal(TemporalType.DATE)
    private Date turnDate;
    @Column(name="status")
    @Basic(optional=false)
    private String status;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "turn_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TurnType turnTypeId;

    public Turn() {
    }

    public Turn(Integer id) {
        this.id = id;
    }

    public Turn(Integer id, int number) {
        this.id = id;
        this.number = number;
    }

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
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTurnDate() {
        return turnDate;
    }

    public void setTurnDate(Date turnDate) {
        this.turnDate = turnDate;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public TurnType getTurnTypeId() {
        return turnTypeId;
    }

    public void setTurnTypeId(TurnType turnTypeId) {
        this.turnTypeId = turnTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turn)) {
            return false;
        }
        Turn other = (Turn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.neoris.support.entities.Turn[ id=" + id + " ]";
    }
    
}
