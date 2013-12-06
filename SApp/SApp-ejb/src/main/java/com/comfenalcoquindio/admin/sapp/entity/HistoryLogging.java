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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rockerW7
 */
@Entity
@Table(name = "history_logging")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoryLogging.findAll", query = "SELECT h FROM HistoryLogging h"),
    @NamedQuery(name = "HistoryLogging.findByIdhistory", query = "SELECT h FROM HistoryLogging h WHERE h.idhistory = :idhistory"),
    @NamedQuery(name = "HistoryLogging.findByDateAdmission", query = "SELECT h FROM HistoryLogging h WHERE h.dateAdmission = :dateAdmission")})
public class HistoryLogging implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhistory")
    private Integer idhistory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_admission")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdmission;
    @JoinColumn(name = "user_account_iduser_account", referencedColumnName = "iduser_account")
    @ManyToOne(optional = false)
    private UserAccount userAccountIduserAccount;

    public HistoryLogging() {
    }

    public HistoryLogging(Integer idhistory) {
        this.idhistory = idhistory;
    }

    public HistoryLogging(Integer idhistory, Date dateAdmission) {
        this.idhistory = idhistory;
        this.dateAdmission = dateAdmission;
    }

    public Integer getIdhistory() {
        return idhistory;
    }

    public void setIdhistory(Integer idhistory) {
        this.idhistory = idhistory;
    }

    public Date getDateAdmission() {
        return dateAdmission;
    }

    public void setDateAdmission(Date dateAdmission) {
        this.dateAdmission = dateAdmission;
    }

    public UserAccount getUserAccountIduserAccount() {
        return userAccountIduserAccount;
    }

    public void setUserAccountIduserAccount(UserAccount userAccountIduserAccount) {
        this.userAccountIduserAccount = userAccountIduserAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhistory != null ? idhistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoryLogging)) {
            return false;
        }
        HistoryLogging other = (HistoryLogging) object;
        if ((this.idhistory == null && other.idhistory != null) || (this.idhistory != null && !this.idhistory.equals(other.idhistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalcoquindio.admin.sapp.entity.HistoryLogging[ idhistory=" + idhistory + " ]";
    }
    
}
