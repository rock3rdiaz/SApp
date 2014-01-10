/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.sapp.controller;

import com.comfenalcoquindio.admin.sapp.dto.Order1DTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author rockerW7
 */
@Named(value = "orderController")
@SessionScoped
public class OrderController implements Serializable {

    private Integer idPurchaseRequest;
    private Integer idProduct;
    private Date needDate;
    private short type;
    private String justification;
    private int amount;

    private List<Order1DTO> orderDTOList;
    
    /**
     * Creates a new instance of OrderController
     */
    public OrderController() {
        orderDTOList = new ArrayList<>();
    }

    public void add() {

        orderDTOList.add( new Order1DTO(type, needDate, justification, amount) );

        cleaningProperties();
    }

    private void cleaningProperties() {
        needDate = null;
        type = 0;
        justification = "";
        amount = 0;
    }

    public List<Order1DTO> getOrderDTOList() {
        return orderDTOList;
    }
    
    public void setOrderDTOList(){
        orderDTOList.clear();
    }

    public Integer getIdPurchaseRequest() {
        return idPurchaseRequest;
    }

    public void setIdPurchaseRequest(Integer idPurchaseRequest) {
        this.idPurchaseRequest = idPurchaseRequest;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Date getNeedDate() {
        return needDate;
    }

    public void setNeedDate(Date needDate) {
        this.needDate = needDate;
    }

    public short getType() {
        return type;
    }

    /**
     * @Summary: Metodo que regresa la cadena de texto correspondiente al codigo del tipo de compra
     * @param type: Codigo del tipo de compra
     * @return name: Nombre del tipo de compra
     */
    public String getTypeName(short type) {
        
        String name;
        
        switch (type) {
            case 1:
                name = "Gasto";
                break;
            case 2:
                name = "Inversion";
                break;
            default:
                name = "Adecuacion";
        }
        return name;
    }

    public void setType(short type) {
        this.type = type;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
