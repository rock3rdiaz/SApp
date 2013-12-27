/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.sapp.controller;

import java.io.Serializable;
import java.sql.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rockerW7
 */
@Named(value = "purchaseRequestController")
@SessionScoped
public class PurchaseRequestController implements Serializable {

    private Integer idPurchaseRequest;
    private Date sendDate;
    private String observations;
    private short state;
    
    @Inject private OrderController orderController;

    @Inject private ProductController productController;

    /**
     * Creates a new instance of PurchaseRequestController
     */
    public PurchaseRequestController() {
    }

    /**
     * @Summary: Metodo que permite crear en memoria los objetos involucrados en
     * la solicitud de compra (formulario 'create.xhtml')
     */
    public void onAdd() {
        System.out.println("Clicked in PurchaseRequestController!");
        
        orderController.add();
        /*productController.add();

        System.out.println("OrderList:");
        for( Order1 order : orderController.getOrderList() ){
            System.out.println("Order Object: " + order);
        }*/
    }

    public Integer getIdPurchaseRequest() {
        return idPurchaseRequest;
    }

    public void setIdPurchaseRequest(Integer idPurchaseRequest) {
        this.idPurchaseRequest = idPurchaseRequest;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }
}
