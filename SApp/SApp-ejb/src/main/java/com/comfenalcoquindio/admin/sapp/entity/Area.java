/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rockerW7
 */
@Entity
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByIdarea", query = "SELECT a FROM Area a WHERE a.idarea = :idarea"),
    @NamedQuery(name = "Area.findByName", query = "SELECT a FROM Area a WHERE a.name = :name")})
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idarea")
    private Integer idarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaIdarea")
    private List<PurchaseRequest> purchaseRequestList;

    public Area() {
    }

    public Area(Integer idarea) {
        this.idarea = idarea;
    }

    public Area(Integer idarea, String name) {
        this.idarea = idarea;
        this.name = name;
    }

    public Integer getIdarea() {
        return idarea;
    }

    public void setIdarea(Integer idarea) {
        this.idarea = idarea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<PurchaseRequest> getPurchaseRequestList() {
        return purchaseRequestList;
    }

    public void setPurchaseRequestList(List<PurchaseRequest> purchaseRequestList) {
        this.purchaseRequestList = purchaseRequestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarea != null ? idarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.idarea == null && other.idarea != null) || (this.idarea != null && !this.idarea.equals(other.idarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalcoquindio.admin.sapp.entity.Area[ idarea=" + idarea + " ]";
    }
    
}
