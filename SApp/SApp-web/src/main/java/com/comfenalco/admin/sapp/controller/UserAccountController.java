/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.sapp.controller;

import com.comfenalcoquindio.admin.sapp.bussines.IUserAccountBean;
import com.comfenalcoquindio.admin.sapp.entity.UserAccount;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author rockerW7
 */
@Named(value = "userAccountController")
@RequestScoped
public class UserAccountController implements Serializable {

    @EJB
    private IUserAccountBean userAccountBean;

    private Integer idUserAccount;
    private String username;
    private String passwd;
    private String profile;
    private int idUser;
    
    private List<UserAccount> userAcconts;

    /**
     * Creates a new instance of UserAccountController
     */
    public UserAccountController() {
    }
    
    public List<UserAccount> getUserAccounts(){
        return userAccountBean.getAll();
    }
    
    public void edit(){
        userAccountBean.update( idUserAccount );
    }

    public void save() {
        
        userAccountBean.add(username, passwd, profile);

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Exito", "Hello " + username));
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

}
