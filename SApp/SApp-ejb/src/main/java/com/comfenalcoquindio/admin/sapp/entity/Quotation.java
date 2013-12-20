/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rockerW7
 */
@Entity
@Table(name = "quotation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quotation.findAll", query = "SELECT q FROM Quotation q"),
    @NamedQuery(name = "Quotation.findByIdQuotation", query = "SELECT q FROM Quotation q WHERE q.idQuotation = :idQuotation"),
    @NamedQuery(name = "Quotation.findByPathFile", query = "SELECT q FROM Quotation q WHERE q.pathFile = :pathFile"),
    @NamedQuery(name = "Quotation.findByAmount", query = "SELECT q FROM Quotation q WHERE q.amount = :amount"),
    @NamedQuery(name = "Quotation.findByObservations", query = "SELECT q FROM Quotation q WHERE q.observations = :observations")})
public class Quotation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_quotation")
    private Integer idQuotation;
    @Size(max = 120)
    @Column(name = "path_file")
    private String pathFile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @Size(max = 120)
    @Column(name = "observations")
    private String observations;
    @JoinColumn(name = "provider_idprovider", referencedColumnName = "idprovider")
    @ManyToOne(optional = false)
    private Provider providerIdprovider;
    @JoinColumn(name = "product_idproduct", referencedColumnName = "idproduct")
    @ManyToOne(optional = false)
    private Product productIdproduct;

    public Quotation() {
    }

    public Quotation(Integer idQuotation) {
        this.idQuotation = idQuotation;
    }

    public Quotation(Integer idQuotation, double amount) {
        this.idQuotation = idQuotation;
        this.amount = amount;
    }

    public Integer getIdQuotation() {
        return idQuotation;
    }

    public void setIdQuotation(Integer idQuotation) {
        this.idQuotation = idQuotation;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Provider getProviderIdprovider() {
        return providerIdprovider;
    }

    public void setProviderIdprovider(Provider providerIdprovider) {
        this.providerIdprovider = providerIdprovider;
    }

    public Product getProductIdproduct() {
        return productIdproduct;
    }

    public void setProductIdproduct(Product productIdproduct) {
        this.productIdproduct = productIdproduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuotation != null ? idQuotation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quotation)) {
            return false;
        }
        Quotation other = (Quotation) object;
        if ((this.idQuotation == null && other.idQuotation != null) || (this.idQuotation != null && !this.idQuotation.equals(other.idQuotation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalcoquindio.admin.sapp.entity.Quotation[ idQuotation=" + idQuotation + " ]";
    }
    
}
