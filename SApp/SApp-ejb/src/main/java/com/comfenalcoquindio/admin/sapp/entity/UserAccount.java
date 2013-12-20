/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "UserAccount.findByUsernameAndPasswd", query = "SELECT u FROM UserAccount u WHERE u.username = :username AND u.passwd = :passwd"),
    @NamedQuery(name = "UserAccount.findByIdUser", query = "SELECT u FROM UserAccount u WHERE u.idUser = :idUser")})
public class UserAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)    
    @Column(name = "iduser_account") 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "profile")
    private int profile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userAccountIduserAccount")
    private List<HistoryLogging> historyLoggingList;

    public UserAccount() {
    }

    public UserAccount(Integer iduserAccount) {
        this.iduserAccount = iduserAccount;
    }

    public UserAccount(Integer iduserAccount, String username, String passwd, int profile, int idUser) {
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

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public List<HistoryLogging> getHistoryLoggingList() {
        return historyLoggingList;
    }

    public void setHistoryLoggingList(List<HistoryLogging> historyLoggingList) {
        this.historyLoggingList = historyLoggingList;
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
        return "com.comfenalcoquindio.admin.sapp.entity.UserAccount[ iduserAccount=" + iduserAccount + ","
                + " username=" + username + ", passwd=" + passwd + ", profile=" + profile  + ", idUser=" + idUser + " ]";
    }
    
    /**
     *@Summary: Metodo que retorna el nombre del perfil de acuerdo al codigo del mismo
     * @return name: Nombre del perfil
     */
    public String getProfileName(){
        
        String name;
        
        switch( profile ){
            case 1:
                name = "Jefe de area";
                break;
            case 2:
                name = "Coordinador de compras";
                break;
            case 3:
                name = "Miembro de comite de compas";
                break;
            default:
                name = "Administrador";                
        }        
        return name;
    }
}
