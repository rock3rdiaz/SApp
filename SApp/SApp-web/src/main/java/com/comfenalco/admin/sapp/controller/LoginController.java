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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rockerW7
 */
@Named(value = "loginController")
@RequestScoped
public class LoginController {

    private String username;
    private String passwd;

    @EJB
    private IUserAccountBean userAccountBean;
    @EJB
    private IAreaManagersBean areaManagersBean;

    /**
     * Creates a new instance of LogginController
     */
    public LoginController() {
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

    public void login() {

        try {
            UserAccount acount = userAccountBean.getByLogin(username, passwd);
            AreaManagers areaManager = areaManagersBean.getByIdentification(acount.getIdUser());

            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

            session.setAttribute("username", username);
            session.setAttribute("profile", acount.getProfile());
            session.setAttribute("identification", acount.getIdUser());
            session.setAttribute("idUserAccount", acount.getIduserAccount());
            session.setAttribute("workerName", areaManager.getWorkerName());
            session.setAttribute("areaName", areaManager.getAreaName());
            session.setAttribute("idArea", areaManager.getIdArea());
            session.setAttribute("postName", areaManager.getPost());
            
            switch (acount.getProfile()) {
                case 1:
                    facesContext.getExternalContext().redirect("faces/boss/index.xhtml");
                    break;

                case 2:
                    facesContext.getExternalContext().redirect("faces/coordinator/index.xhtml");
                    break;

                case 3:
                    facesContext.getExternalContext().redirect("faces/committe/index.xhtml");
                    break;

                default:
                    facesContext.getExternalContext().redirect("faces/admin/index.xhtml");
                    break;
            }
        } catch (Exception e) {
            System.out.println("ERROR!: " + e.getCause());

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    ":\'(", "Error de inicio de sesion. Verifique sus datos. \"" + e.getCause().getMessage() + "\"");

            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().invalidateSession();

        try {
            facesContext.getExternalContext().redirect("/SApp-web/faces/login.xhtml");
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
