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
    @NamedQuery(name = "AreaManagers.findByName", query = "SELECT a FROM AreaManagers a WHERE a.name = :name"),
    @NamedQuery(name = "AreaManagers.findByDescription", query = "SELECT a FROM AreaManagers a WHERE a.description = :description")})
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
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;

    public AreaManagers() {
    }

    public long getIdentification() {
        return identification;
    }

    public void setIdentification(long identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
