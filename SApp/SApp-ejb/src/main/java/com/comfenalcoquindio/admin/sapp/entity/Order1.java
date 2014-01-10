/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalcoquindio.admin.sapp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rockerW7
 */
@Entity
@Table(name = "[order]")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findByPurchaseRequestIdpurchaseRequest", query = "SELECT o FROM Order1 o WHERE o.order1PK.purchaseRequestIdpurchaseRequest = :purchaseRequestIdpurchaseRequest"),
    @NamedQuery(name = "Order1.findByProductIdproduct", query = "SELECT o FROM Order1 o WHERE o.order1PK.productIdproduct = :productIdproduct"),
    @NamedQuery(name = "Order1.findByType", query = "SELECT o FROM Order1 o WHERE o.type = :type"),
    @NamedQuery(name = "Order1.findByNeedDate", query = "SELECT o FROM Order1 o WHERE o.needDate = :needDate"),
    @NamedQuery(name = "Order1.findByJustification", query = "SELECT o FROM Order1 o WHERE o.justification = :justification"),
    @NamedQuery(name = "Order1.findByAmount", query = "SELECT o FROM Order1 o WHERE o.amount = :amount")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Order1PK order1PK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private short type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "need_date")
    @Temporal(TemporalType.DATE)
    private Date needDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "justification")
    private String justification;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @JoinColumn(name = "purchase_request_idpurchase_request", referencedColumnName = "idpurchase_request", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PurchaseRequest purchaseRequest;
    @JoinColumn(name = "product_idproduct", referencedColumnName = "idproduct", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public Order1() {
    }

    public Order1(Order1PK order1PK) {
        this.order1PK = order1PK;
    }

    public Order1(Order1PK order1PK, short type, Date needDate, String justification, short amount) {
        this.order1PK = order1PK;
        this.type = type;
        this.needDate = needDate;
        this.justification = justification;
        this.amount = amount;
    }

    public Order1(int purchaseRequestIdpurchaseRequest, int productIdproduct) {
        this.order1PK = new Order1PK(purchaseRequestIdpurchaseRequest, productIdproduct);
    }

    public Order1PK getOrder1PK() {
        return order1PK;
    }

    public void setOrder1PK(Order1PK order1PK) {
        this.order1PK = order1PK;
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

    public PurchaseRequest getPurchaseRequest() {
        return purchaseRequest;
    }

    public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
        this.purchaseRequest = purchaseRequest;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (order1PK != null ? order1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.order1PK == null && other.order1PK != null) || (this.order1PK != null && !this.order1PK.equals(other.order1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order1{" + "order1PK=" + order1PK + ", type=" + type + ", needDate="
                + needDate + ", justification=" + justification + ", amount="
                + amount + ", purchaseRequest=" + purchaseRequest + ", product=" + product + '}';
    }

}
