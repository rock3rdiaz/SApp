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
@Table(name = "committe_meeting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommitteMeeting.findAll", query = "SELECT c FROM CommitteMeeting c"),
    @NamedQuery(name = "CommitteMeeting.findByIdcommitteMeeting", query = "SELECT c FROM CommitteMeeting c WHERE c.idcommitteMeeting = :idcommitteMeeting"),
    @NamedQuery(name = "CommitteMeeting.findByDate", query = "SELECT c FROM CommitteMeeting c WHERE c.date = :date"),
    @NamedQuery(name = "CommitteMeeting.findByObservations", query = "SELECT c FROM CommitteMeeting c WHERE c.observations = :observations")})
public class CommitteMeeting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcommitte_meeting")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer idcommitteMeeting;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 120)
    @Column(name = "observations")
    private String observations;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calendarIdcalendar")
    private List<PurchaseAct> purchaseActList;

    public CommitteMeeting() {
    }

    public CommitteMeeting(Integer idcommitteMeeting) {
        this.idcommitteMeeting = idcommitteMeeting;
    }

    public CommitteMeeting(Integer idcommitteMeeting, Date date) {
        this.idcommitteMeeting = idcommitteMeeting;
        this.date = date;
    }

    public Integer getIdcommitteMeeting() {
        return idcommitteMeeting;
    }

    public void setIdcommitteMeeting(Integer idcommitteMeeting) {
        this.idcommitteMeeting = idcommitteMeeting;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @XmlTransient
    public List<PurchaseAct> getPurchaseActList() {
        return purchaseActList;
    }

    public void setPurchaseActList(List<PurchaseAct> purchaseActList) {
        this.purchaseActList = purchaseActList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcommitteMeeting != null ? idcommitteMeeting.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommitteMeeting)) {
            return false;
        }
        CommitteMeeting other = (CommitteMeeting) object;
        if ((this.idcommitteMeeting == null && other.idcommitteMeeting != null) || (this.idcommitteMeeting != null && !this.idcommitteMeeting.equals(other.idcommitteMeeting))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalcoquindio.admin.sapp.entity.CommitteMeeting[ idcommitteMeeting=" + idcommitteMeeting + " ]";
    }
    
}
