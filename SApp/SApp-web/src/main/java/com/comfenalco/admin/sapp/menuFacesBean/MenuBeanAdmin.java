/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.sapp.menuFacesBean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author rockerW7
 */
@Named(value = "menuBeanAdmin")
@RequestScoped
public class MenuBeanAdmin {

    private MenuModel model;

    /**
     * Creates a new instance of MenuBeanAdmin
     */
    public MenuBeanAdmin() {

        model = new DefaultMenuModel();

        //First submenu  
        DefaultSubMenu userAccounts = new DefaultSubMenu("Cuentas de usuario");

        DefaultMenuItem item = new DefaultMenuItem("Listar cuenta de usuario");
        item.setIcon("ui-icon-plus");        
        //item.setUrl("listUserAccount.xhtml");
        item.setAjax(true);
        userAccounts.addElement(item);

        model.addElement(userAccounts);

        //Second submenu  
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");

        item = new DefaultMenuItem("Save");
        item.setIcon("ui-icon-disk");
        item.setCommand("#{menuBeanBoss.save}");
        item.setUpdate("messages");
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Delete");
        item.setIcon("ui-icon-close");
        item.setCommand("#{menuBeanBoss.delete}");
        item.setAjax(false);
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Redirect");
        item.setIcon("ui-icon-search");
        item.setCommand("#{menuBeanBoss.redirect}");
        secondSubmenu.addElement(item);

        model.addElement(secondSubmenu);
    }
    
    public MenuModel getModel() {
        return model;
    }

    public void save() {
        addMessage("Data saved");
    }

    public void update() {
        addMessage("Data updated");
    }

    public void delete() {
        addMessage("Data deleted");
    }

    public String redirect() {
        return "home?faces-redirect=true";
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
