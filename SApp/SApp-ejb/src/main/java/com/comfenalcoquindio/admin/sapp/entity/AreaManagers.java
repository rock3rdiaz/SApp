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
@Table(name = "area_managers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaManagers.findAll", query = "SELECT a FROM AreaManagers a"),
    @NamedQuery(name = "AreaManagers.findByIdentification", query = "SELECT a FROM AreaManagers a WHERE a.identification = :identification"),
    @NamedQuery(name = "AreaManagers.findByWorkerName", query = "SELECT a FROM AreaManagers a WHERE a.workerName = :workerName"),
    @NamedQuery(name = "AreaManagers.findByPost", query = "SELECT a FROM AreaManagers a WHERE a.post = :post"),
    @NamedQuery(name = "AreaManagers.findByIdArea", query = "SELECT a FROM AreaManagers a WHERE a.idArea = :idArea"),
    @NamedQuery(name = "AreaManagers.findByAreaName", query = "SELECT a FROM AreaManagers a WHERE a.areaName = :areaName")})
public class AreaManagers implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "identification")
    private long identification;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "WorkerName")
    private String workerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Post")
    private String post;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdArea")
    private int idArea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "AreaName")
    private String areaName;

    public AreaManagers() {
    }

    public long getIdentification() {
        return identification;
    }

    public void setIdentification(long identification) {
        this.identification = identification;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    
}
