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
    @NamedQuery(name = "PurchaseRequest.findBySendDate", query = "SELECT p FROM PurchaseRequest p WHERE p.sendDate = :sendDate"),
    @NamedQuery(name = "PurchaseRequest.findByObservations", query = "SELECT p FROM PurchaseRequest p WHERE p.observations = :observations"),
    @NamedQuery(name = "PurchaseRequest.findByState", query = "SELECT p FROM PurchaseRequest p WHERE p.state = :state")})
public class PurchaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpurchase_request")
    private Integer idpurchaseRequest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "send_date")
    @Temporal(TemporalType.DATE)
    private Date sendDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "observations")
    private String observations;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state")
    private short state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseRequest")
    private List<Order1> order1List;
    @JoinColumn(name = "purchase_act_idpurchase_act", referencedColumnName = "idpurchase_act")
    @ManyToOne
    private PurchaseAct purchaseActIdpurchaseAct;
    @JoinColumn(name = "area_idarea", referencedColumnName = "idarea")
    @ManyToOne(optional = false)
    private Area areaIdarea;

    public PurchaseRequest() {
    }

    public PurchaseRequest(Integer idpurchaseRequest) {
        this.idpurchaseRequest = idpurchaseRequest;
    }

    public PurchaseRequest(Integer idpurchaseRequest, Date sendDate, String observations, short state) {
        this.idpurchaseRequest = idpurchaseRequest;
        this.sendDate = sendDate;
        this.observations = observations;
        this.state = state;
    }

    public Integer getIdpurchaseRequest() {
        return idpurchaseRequest;
    }

    public void setIdpurchaseRequest(Integer idpurchaseRequest) {
        this.idpurchaseRequest = idpurchaseRequest;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    @XmlTransient
    public List<Order1> getOrder1List() {
        return order1List;
    }

    public void setOrder1List(List<Order1> order1List) {
        this.order1List = order1List;
    }

    public PurchaseAct getPurchaseActIdpurchaseAct() {
        return purchaseActIdpurchaseAct;
    }

    public void setPurchaseActIdpurchaseAct(PurchaseAct purchaseActIdpurchaseAct) {
        this.purchaseActIdpurchaseAct = purchaseActIdpurchaseAct;
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
