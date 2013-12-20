/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.sapp.controller;

import com.comfenalcoquindio.admin.sapp.bussines.IAreaManagersBean;
import com.comfenalcoquindio.admin.sapp.bussines.IUserAccountBean;
import com.comfenalcoquindio.admin.sapp.entity.AreaManagers;
import com.comfenalcoquindio.admin.sapp.entity.UserAccount;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author rockerW7
 */
@Named(value = "userAccountController")
@SessionScoped
public class UserAccountController implements Serializable {

    @EJB
    private IUserAccountBean userAccountBean;
    @EJB
    private IAreaManagersBean areaManagers;

    private Integer iduserAccount;
    private String username;
    private String passwd;
    private int profile;
    private int idUser;

    private UserAccount myUserAccount;

    private List<UserAccount> userAccountsList;
    private List<AreaManagers> areaManagersList;

    /**
     * Creates a new instance of UserAccountController
     */
    public UserAccountController() {
        userAccountsList = new ArrayList<>();
    }

    public List<AreaManagers> getAreaManagersList() {
        return areaManagers.getAll();
    }

    public List<UserAccount> getUserAccountsList() {

        if (userAccountsList.isEmpty()) {
            userAccountsList = userAccountBean.getAll();
        }

        return userAccountsList;
    }

    public UserAccount getMyUserAccount(int identification) {
        myUserAccount = userAccountBean.getByIdUser(identification);
        return myUserAccount;
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

    /**
     * @Summary: Methodo que reinicializa las propiedades del objeto
     */
    public void cleaningProperties() {

        username = "";
        passwd = "";
        profile = 0;
        idUser = 0;
    }

    public void onSave() {

        try {
            userAccountBean.add(username, passwd, profile, idUser);

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    ":)", "Registro guardado con exito!");

            FacesContext.getCurrentInstance().addMessage(null, msg);

            cleaningProperties();

        } catch (Exception e) {

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    ":\'(", "No se pudo guardar el registro! " + e.getCause().getMessage());

            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onDelete(UserAccount userAccount) {

        try {
            userAccountBean.delete(userAccount);

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    ":)", "Registro eliminado con exito!");

            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    ":\'(", "No se pudo eliminar el registro! " + e.getCause().getMessage());

            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onCancel(RowEditEvent event) {

        FacesMessage msg = new FacesMessage(":(", "Actualizacion cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     *
     * @Summary: Metodo que actualiza el objeto "UserAccount" que ha sido
     * modificado
     * @param event: Evento "RowEditEvent" que contiene el objeto modificado
     */
    public void onEdit(RowEditEvent event) {

        UserAccount userAccount = (UserAccount) event.getObject();

        try {
            userAccountBean.update(userAccount);

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    ":)",
                    "La cuenta de usuario \"" + userAccount.getUsername()
                    + "\" ha sido modificada exitosamente");

            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Error",
                    e.getCause().toString());

            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onEditMyAccount() {

        try {
            
            System.out.println("In onEditMyAccount()");
            userAccountBean.update(myUserAccount);

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    ":)",
                    "La cuenta de usuario \"" + myUserAccount.getUsername()
                    + "\" ha sido modificada exitosamente");

            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Error",
                    e.getCause().toString());

            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
