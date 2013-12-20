/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.dto;

/**
 *
 * @author rockerW7
 */
public class UserAccountDTO {
    
    private Integer iduserAccount;  
    private String username;
    private String passwd;
    private int profile;
    private int idUser;

    public UserAccountDTO(String username, String passwd, int profile, int idUser) {
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

    @Override
    public String toString() {
        return "UserAccountDTO{" + "iduserAccount=" + iduserAccount + ", username=" + username + ", passwd=" + passwd + ", profile=" + profile + ", idUser=" + idUser + '}';
    }
}
