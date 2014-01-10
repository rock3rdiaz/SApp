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
public class Order1DTO {
    
    private short type;
    private Date needDate;
    private String justification;
    private int amount;

    public Order1DTO() {
    }

    public Order1DTO(short type, Date needDate, String justification, int amount) {
        this.type = type;
        this.needDate = needDate;
        this.justification = justification;
        this.amount = amount;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public Date getNeedDate() {
        return needDate;
    }

    public void setNeedDate(Date needDate) {
        this.needDate = needDate;
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
