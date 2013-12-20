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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rockerW7
 */
@Entity
@Table(name = "purchase_act")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseAct.findAll", query = "SELECT p FROM PurchaseAct p"),
    @NamedQuery(name = "PurchaseAct.findByIdpurchaseAct", query = "SELECT p FROM PurchaseAct p WHERE p.idpurchaseAct = :idpurchaseAct"),
    @NamedQuery(name = "PurchaseAct.findByCreateDate", query = "SELECT p FROM PurchaseAct p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "PurchaseAct.findByState", query = "SELECT p FROM PurchaseAct p WHERE p.state = :state")})
public class PurchaseAct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpurchase_act")
    private Integer idpurchaseAct;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state")
    private short state;
    @JoinColumn(name = "calendar_idcalendar", referencedColumnName = "idcommitte_meeting")
    @ManyToOne(optional = false)
    private CommitteMeeting calendarIdcalendar;
    @OneToMany(mappedBy = "purchaseActIdpurchaseAct")
    private List<PurchaseRequest> purchaseRequestList;

    public PurchaseAct() {
    }

    public PurchaseAct(Integer idpurchaseAct) {
        this.idpurchaseAct = idpurchaseAct;
    }

    public PurchaseAct(Integer idpurchaseAct, short state) {
        this.idpurchaseAct = idpurchaseAct;
        this.state = state;
    }

    public Integer getIdpurchaseAct() {
        return idpurchaseAct;
    }

    public void setIdpurchaseAct(Integer idpurchaseAct) {
        this.idpurchaseAct = idpurchaseAct;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public CommitteMeeting getCalendarIdcalendar() {
        return calendarIdcalendar;
    }

    public void setCalendarIdcalendar(CommitteMeeting calendarIdcalendar) {
        this.calendarIdcalendar = calendarIdcalendar;
    }

    @XmlTransient
    public List<PurchaseRequest> getPurchaseRequestList() {
        return purchaseRequestList;
    }

    public void setPurchaseRequestList(List<PurchaseRequest> purchaseRequestList) {
        this.purchaseRequestList = purchaseRequestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpurchaseAct != null ? idpurchaseAct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseAct)) {
            return false;
        }
        PurchaseAct other = (PurchaseAct) object;
        if ((this.idpurchaseAct == null && other.idpurchaseAct != null) || (this.idpurchaseAct != null && !this.idpurchaseAct.equals(other.idpurchaseAct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalcoquindio.admin.sapp.entity.PurchaseAct[ idpurchaseAct=" + idpurchaseAct + " ]";
    }
    
}
