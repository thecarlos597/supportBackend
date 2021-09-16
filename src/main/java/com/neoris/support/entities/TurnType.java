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
@Table(name = "turn_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TurnType.findAll", query = "SELECT t FROM TurnType t"),
    @NamedQuery(name = "TurnType.findById", query = "SELECT t FROM TurnType t WHERE t.id = :id"),
    @NamedQuery(name = "TurnType.findByDesc", query = "SELECT t FROM TurnType t WHERE t.desc = :desc")})
public class TurnType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "desc")
    private String desc;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turnTypeId")
    private List<TypeCustomer> typeCustomerList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turnTypeId")
    private List<Turn> turnList;

    public TurnType() {
    }

    public TurnType(Integer id) {
        this.id = id;
    }

    public TurnType(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @XmlTransient
    public List<TypeCustomer> getTypeCustomerList() {
        return typeCustomerList;
    }

    public void setTypeCustomerList(List<TypeCustomer> typeCustomerList) {
        this.typeCustomerList = typeCustomerList;
    }

    @XmlTransient
    public List<Turn> getTurnList() {
        return turnList;
    }

    public void setTurnList(List<Turn> turnList) {
        this.turnList = turnList;
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
        if (!(object instanceof TurnType)) {
            return false;
        }
        TurnType other = (TurnType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.neoris.support.entities.TurnType[ id=" + id + " ]";
    }
    
}
