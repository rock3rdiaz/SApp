/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rockerW7
 */
@Entity
@Table(name = "user_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAccount.findAll", query = "SELECT u FROM UserAccount u"),
    @NamedQuery(name = "UserAccount.findByIduserAccount", query = "SELECT u FROM UserAccount u WHERE u.iduserAccount = :iduserAccount"),
    @NamedQuery(name = "UserAccount.findByUsername", query = "SELECT u FROM UserAccount u WHERE u.username = :username"),
    @NamedQuery(name = "UserAccount.findByPasswd", query = "SELECT u FROM UserAccount u WHERE u.passwd = :passwd"),
    @NamedQuery(name = "UserAccount.findByProfile", query = "SELECT u FROM UserAccount u WHERE u.profile = :profile"),
    @NamedQuery(name = "UserAccount.findByIdUser", query = "SELECT u FROM UserAccount u WHERE u.idUser = :idUser")})
public class UserAccount implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iduser_account")
    private Integer iduserAccount;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "passwd")
    private String passwd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "profile")
    private String profile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;

    public UserAccount() {
    }

    public UserAccount(Integer iduserAccount) {
        this.iduserAccount = iduserAccount;
    }

    public UserAccount(Integer iduserAccount, String username, String passwd, String profile, int idUser) {
        this.iduserAccount = iduserAccount;
        this.username = username;
        this.passwd = passwd;
        this.profile = profile;
        this.idUser = idUser;
    }

    public Integer getIduserAccount() {
        return iduserAccount;
    }

    public void setIduserAccount(Integer iduserAccount) {
        this.iduserAccount = iduserAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduserAccount != null ? iduserAccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAccount)) {
            return false;
        }
        UserAccount other = (UserAccount) object;
        if ((this.iduserAccount == null && other.iduserAccount != null) || (this.iduserAccount != null && !this.iduserAccount.equals(other.iduserAccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalcoquindio.admin.sapp.entity.UserAccount[ iduserAccount=" + iduserAccount + " ]";
    }
    
}
