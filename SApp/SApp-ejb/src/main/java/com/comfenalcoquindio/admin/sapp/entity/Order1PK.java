/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rockerW7
 */
@Embeddable
public class Order1PK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "purchase_request_idpurchase_request")
    private int purchaseRequestIdpurchaseRequest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_idproduct")
    private int productIdproduct;

    public Order1PK() {
    }

    public Order1PK(int purchaseRequestIdpurchaseRequest, int productIdproduct) {
        this.purchaseRequestIdpurchaseRequest = purchaseRequestIdpurchaseRequest;
        this.productIdproduct = productIdproduct;
    }

    public int getPurchaseRequestIdpurchaseRequest() {
        return purchaseRequestIdpurchaseRequest;
    }

    public void setPurchaseRequestIdpurchaseRequest(int purchaseRequestIdpurchaseRequest) {
        this.purchaseRequestIdpurchaseRequest = purchaseRequestIdpurchaseRequest;
    }

    public int getProductIdproduct() {
        return productIdproduct;
    }

    public void setProductIdproduct(int productIdproduct) {
        this.productIdproduct = productIdproduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) purchaseRequestIdpurchaseRequest;
        hash += (int) productIdproduct;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1PK)) {
            return false;
        }
        Order1PK other = (Order1PK) object;
        if (this.purchaseRequestIdpurchaseRequest != other.purchaseRequestIdpurchaseRequest) {
            return false;
        }
        if (this.productIdproduct != other.productIdproduct) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalcoquindio.admin.sapp.entity.Order1PK[ purchaseRequestIdpurchaseRequest=" + purchaseRequestIdpurchaseRequest + ", productIdproduct=" + productIdproduct + " ]";
    }
    
}
