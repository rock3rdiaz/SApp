/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rockerW7
 */
@Entity
@Table(name = "purchase_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseRequest.findAll", query = "SELECT p FROM PurchaseRequest p"),
    @NamedQuery(name = "PurchaseRequest.findByIdpurchaseRequest", query = "SELECT p FROM PurchaseRequest p WHERE p.idpurchaseRequest = :idpurchaseRequest"),
    @NamedQuery(name = "PurchaseRequest.findByDateField", query = "SELECT p FROM PurchaseRequest p WHERE p.dateField = :dateField"),
    @NamedQuery(name = "PurchaseRequest.findByObservations", query = "SELECT p FROM PurchaseRequest p WHERE p.observations = :observations")})
public class PurchaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpurchase_request")
    private Integer idpurchaseRequest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_field")
    @Temporal(TemporalType.DATE)
    private Date dateField;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "observations")
    private String observations;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseRequest")
    private List<Order1> order1List;
    @JoinColumn(name = "area_idarea", referencedColumnName = "idarea")
    @ManyToOne(optional = false)
    private Area areaIdarea;

    public PurchaseRequest() {
    }

    public PurchaseRequest(Integer idpurchaseRequest) {
        this.idpurchaseRequest = idpurchaseRequest;
    }

    public PurchaseRequest(Integer idpurchaseRequest, Date dateField, String observations) {
        this.idpurchaseRequest = idpurchaseRequest;
        this.dateField = dateField;
        this.observations = observations;
    }

    public Integer getIdpurchaseRequest() {
        return idpurchaseRequest;
    }

    public void setIdpurchaseRequest(Integer idpurchaseRequest) {
        this.idpurchaseRequest = idpurchaseRequest;
    }

    public Date getDateField() {
        return dateField;
    }

    public void setDateField(Date dateField) {
        this.dateField = dateField;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @XmlTransient
    public List<Order1> getOrder1List() {
        return order1List;
    }

    public void setOrder1List(List<Order1> order1List) {
        this.order1List = order1List;
    }

    public Area getAreaIdarea() {
        return areaIdarea;
    }

    public void setAreaIdarea(Area areaIdarea) {
        this.areaIdarea = areaIdarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpurchaseRequest != null ? idpurchaseRequest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseRequest)) {
            return false;
        }
        PurchaseRequest other = (PurchaseRequest) object;
        if ((this.idpurchaseRequest == null && other.idpurchaseRequest != null) || (this.idpurchaseRequest != null && !this.idpurchaseRequest.equals(other.idpurchaseRequest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalcoquindio.admin.sapp.entity.PurchaseRequest[ idpurchaseRequest=" + idpurchaseRequest + " ]";
    }
    
}
