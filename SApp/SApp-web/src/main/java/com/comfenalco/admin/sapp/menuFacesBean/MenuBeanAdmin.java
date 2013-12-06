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
@Named
@RequestScoped
public class MenuBeanAdmin {

    private MenuModel model;

    /**
     * Creates a new instance of MenuBeanAdmin
     */
    public MenuBeanAdmin() {

        model = new DefaultMenuModel();
        
        DefaultSubMenu home = new DefaultSubMenu( "Home" );
        
        DefaultMenuItem notes = new DefaultMenuItem( "Notas importantes" );
        notes.setIcon( "ui-icon-plus" );        
        DefaultMenuItem statistics = new DefaultMenuItem( "Estadisticas generales" );
        statistics.setIcon( "ui-icon-plus" );        
        DefaultMenuItem upcomingMeetings = new DefaultMenuItem( "Proximas reuniones" );
        upcomingMeetings.setIcon( "ui-icon-plus" );
        
        home.addElement( notes );
        home.addElement( statistics );
        home.addElement( upcomingMeetings );
        
        model.addElement( home );
        
        //Submenu de cuentas de usuario  
        DefaultSubMenu userAccounts = new DefaultSubMenu("Cuentas de usuario");

        DefaultMenuItem item = new DefaultMenuItem("Listar cuenta de usuario");
        item.setIcon("ui-icon-plus");        
        item.setUrl("./userAccounts/list.xhtml");
        item.setAjax(true);
        userAccounts.addElement(item);

        model.addElement(userAccounts);

        //Submenu de fechas de comite de compras  
        DefaultSubMenu datesComitte = new DefaultSubMenu("Fechas del comite de compras");

        item = new DefaultMenuItem("Listar fechas de reunion del comite");
        item.setIcon("ui-icon-calendar");
        //item.setCommand("#{menuBeanBoss.save}");
        item.setUpdate("messages");
        datesComitte.addElement(item);

        /*item = new DefaultMenuItem("Delete");
        item.setIcon("ui-icon-close");
        item.setCommand("#{menuBeanBoss.delete}");
        item.setAjax(false);
        datesComitte.addElement(item);

        item = new DefaultMenuItem("Redirect");
        item.setIcon("ui-icon-search");
        item.setCommand("#{menuBeanBoss.redirect}");
        secondSubmenu.addElement(item);*/

        model.addElement(datesComitte);
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
