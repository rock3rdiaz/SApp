/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.dto;

import java.util.Date;

/**
 *
 * @author rockerW7
 */
public class PurchaseRequestDTO {
    
    private Integer idpurchaseRequest;
    private Date sendDate;
    private String observations;
    private int state;
    private int idarea;
    
    public PurchaseRequestDTO(){
        
    }

    public PurchaseRequestDTO(Date sendDate, String observations, int state, int idarea) {
        this.sendDate = sendDate;
        this.observations = observations;
        this.state = state;
        this.idarea = idarea;
    }

    public Integer getIdpurchaseRequest() {
        return idpurchaseRequest;
    }

    public void setIdpurchaseRequest(Integer idpurchaseRequest) {
        this.idpurchaseRequest = idpurchaseRequest;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getIdarea() {
        return idarea;
    }

    public void setIdarea(int idarea) {
        this.idarea = idarea;
    }   

    @Override
    public String toString() {
        return "PurchaseRequestDTO{" + "idpurchaseRequest=" + idpurchaseRequest + 
                ", sendDate=" + sendDate + ", observations=" + observations + 
                ", state=" + state + ", idarea=" + idarea + '}';
    }
}
