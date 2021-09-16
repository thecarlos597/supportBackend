/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neoris.support.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlos.arodriguez
 */
@Entity
@Table(name = "type_customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeCustomer.findAll", query = "SELECT t FROM TypeCustomer t"),
    @NamedQuery(name = "TypeCustomer.findById", query = "SELECT t FROM TypeCustomer t WHERE t.id = :id"),
    @NamedQuery(name = "TypeCustomer.findByDescription", query = "SELECT t FROM TypeCustomer t WHERE t.description = :description")})
public class TypeCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "turn_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TurnType turnTypeId;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeCustomerId")
    private List<Customer> customerList;

    public TypeCustomer() {
    }

    public TypeCustomer(Integer id) {
        this.id = id;
    }

    public TypeCustomer(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TurnType getTurnTypeId() {
        return turnTypeId;
    }

    public void setTurnTypeId(TurnType turnTypeId) {
        this.turnTypeId = turnTypeId;
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
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
        if (!(object instanceof TypeCustomer)) {
            return false;
        }
        TypeCustomer other = (TypeCustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.neoris.support.entities.TypeCustomer[ id=" + id + " ]";
    }
    
}
