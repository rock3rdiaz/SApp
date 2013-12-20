/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalco.admin.sapp.controller;

import java.sql.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author rockerW7
 */
@Named(value = "purchaseRequestController")
@RequestScoped
public class PurchaseRequestController {
    
    private Integer idPurchaseRequest;
    private Date sendDate;
    private String observations;
    
    

    /**
     * Creates a new instance of PurchaseRequestController
     */
    public PurchaseRequestController() {
    }
    
}
