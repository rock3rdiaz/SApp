/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.sapp.menuFacesBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author rockerW7
 */
@Named(value = "menuBeanBoss")
@RequestScoped
public class MenuBeanBoss {

    private MenuModel model;

    public MenuBeanBoss() {

        model = new DefaultMenuModel();

        //Menu 'Mi cuenta' 
        DefaultSubMenu myAccount = new DefaultSubMenu("Mi cuenta");
        DefaultMenuItem myData = new DefaultMenuItem("Mis datos de perfil");
        myData.setUrl("/faces/boss/myAccount/list.xhtml");
        myData.setIcon("ui-icon-home");
        myAccount.addElement(myData);

        model.addElement(myAccount);

        //Menu 'Solicitudes de compra'  
        DefaultSubMenu purchaseRequest = new DefaultSubMenu("Mis solicitudes de compra");

        DefaultMenuItem create = new DefaultMenuItem("Crear solicitud de compra");
        create.setUrl("/faces/boss/purchaseRequests/create.xhtml");
        create.setIcon("ui-icon-plus");
        purchaseRequest.addElement(create);

        DefaultMenuItem list = new DefaultMenuItem("Listar solicitudes realizadas");
        list.setUrl("/faces/boss/purchaseRequests/list.xhtml");
        list.setIcon("ui-icon-search");
        purchaseRequest.addElement(list);

        model.addElement(purchaseRequest);
    }

    public MenuModel getModel() {
        return model;
    }
}
