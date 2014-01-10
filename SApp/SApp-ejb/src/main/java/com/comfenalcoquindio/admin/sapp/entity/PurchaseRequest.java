/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
    @NamedQuery(name = "PurchaseRequest.findByState", query = "SELECT p FROM PurchaseRequest p WHERE p.state = :state"),
    @NamedQuery(name = "PurchaseRequest.findByIdarea", query = "SELECT p FROM PurchaseRequest p WHERE p.idarea = :idarea")})
public class PurchaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)    
    @Column(name = "idpurchase_request")    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpurchaseRequest;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "send_date")
    @Temporal(TemporalType.DATE)
    private Date sendDate;
    @Size(max = 120)
    @Column(name = "observations")
    private String observations;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state")
    private int state;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idarea")
    private int idarea;
    @JoinColumn(name = "purchase_act_idpurchase_act", referencedColumnName = "idpurchase_act")
    @ManyToOne
    private PurchaseAct purchaseActIdpurchaseAct;

    public PurchaseRequest() {
    }

    public PurchaseRequest(Integer idpurchaseRequest) {
        this.idpurchaseRequest = idpurchaseRequest;
    }

    public PurchaseRequest(Integer idpurchaseRequest, Date sendDate, int state, int idarea) {
        this.idpurchaseRequest = idpurchaseRequest;
        this.sendDate = sendDate;
        this.state = state;
        this.idarea = idarea;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getIdarea() {
        return idarea;
    }

    public void setIdarea(int idarea) {
        this.idarea = idarea;
    }

    public PurchaseAct getPurchaseActIdpurchaseAct() {
        return purchaseActIdpurchaseAct;
    }

    public void setPurchaseActIdpurchaseAct(PurchaseAct purchaseActIdpurchaseAct) {
        this.purchaseActIdpurchaseAct = purchaseActIdpurchaseAct;
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
        return "PurchaseRequest{" + "idpurchaseRequest=" + idpurchaseRequest + ", sendDate=" + sendDate + ", observations=" + observations + ", state=" + state + ", idarea=" + idarea + ", purchaseActIdpurchaseAct=" + purchaseActIdpurchaseAct + '}';
    }
}
