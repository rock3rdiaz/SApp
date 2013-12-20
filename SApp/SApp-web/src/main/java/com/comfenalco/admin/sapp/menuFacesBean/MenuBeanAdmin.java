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

        //Submenu de opciones varias
        DefaultSubMenu home = new DefaultSubMenu("Home");

        DefaultMenuItem notes = new DefaultMenuItem("Notas importantes");
        notes.setIcon("ui-icon-plus");
        DefaultMenuItem statistics = new DefaultMenuItem("Estadisticas generales");
        statistics.setIcon("ui-icon-plus");
        DefaultMenuItem upcomingMeetings = new DefaultMenuItem("Proximas reuniones");
        upcomingMeetings.setIcon("ui-icon-plus");
        home.addElement(notes);
        home.addElement(statistics);
        home.addElement(upcomingMeetings);

        model.addElement(home);

        //Submenu de cuentas de usuario  
        DefaultSubMenu userAccounts = new DefaultSubMenu("Cuentas de usuario");

        DefaultMenuItem new_count = new DefaultMenuItem("Crear cuenta de usuario");
        new_count.setIcon("ui-icon-plus");
        new_count.setUrl("/faces/admin/userAccounts/create.xhtml");

        userAccounts.addElement(new_count);
        DefaultMenuItem userList = new DefaultMenuItem("Listar cuenta de usuario");
        userList.setIcon("ui-icon-plus");
        userList.setUrl("/faces/admin/userAccounts/list.xhtml");
        userAccounts.addElement(userList);

        model.addElement(userAccounts);

        //Submenu de fechas de comite de compras  
        DefaultSubMenu datesComitte = new DefaultSubMenu("Fechas del comite de compras");

        DefaultMenuItem create = new DefaultMenuItem("Crear fecha de reunion");
        create.setIcon("ui-icon-plus");
        create.setUrl( "/faces/admin/committeMeeting/create.xhtml" );
        datesComitte.addElement(create);
        DefaultMenuItem meetingList = new DefaultMenuItem("Listar fechas de reunion del comite");
        meetingList.setIcon("ui-icon-calendar");
        meetingList.setUrl( "/faces/admin/committeMeeting/list.xhtml" );
        datesComitte.addElement(meetingList);        
        
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
