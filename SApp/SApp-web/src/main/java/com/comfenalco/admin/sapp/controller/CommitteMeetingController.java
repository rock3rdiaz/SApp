/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.sapp.controller;

import com.comfenalcoquindio.admin.sapp.bussines.ICommitteMeetingBean;
import com.comfenalcoquindio.admin.sapp.entity.CommitteMeeting;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author rockerW7
 */
@Named(value = "committeMeetingController")
@SessionScoped
public class CommitteMeetingController implements Serializable {

    private Integer idcommitteMeeting;
    private Date date;
    private String observations;

    private List<CommitteMeeting> committeMeetingList;

    @EJB
    private ICommitteMeetingBean committeMeetingBean;

    /**
     * Creates a new instance of CommitteMeetingController
     */
    public CommitteMeetingController() {

        committeMeetingList = new ArrayList<>();
    }

    public List<CommitteMeeting> getCommiteMettingList() {

        if (committeMeetingList.isEmpty()) {
            committeMeetingList = committeMeetingBean.getAll();
        }

        return committeMeetingList;
    }

    public Integer getIdcommitteMeeting() {
        return idcommitteMeeting;
    }

    public void setIdcommitteMeeting(Integer idcommitteMeeting) {
        this.idcommitteMeeting = idcommitteMeeting;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public void onSave() {

        try {
            committeMeetingBean.add(date, observations);

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    ":)", "Registro guardado con exito!");

            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    ":\'(", "No se pudo guardar el registro! " + e.getCause().getMessage());

            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onEdit(RowEditEvent event) {

        CommitteMeeting commiteMeeting = (CommitteMeeting) event.getObject();

        try {
            committeMeetingBean.update(commiteMeeting);

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    ":)",
                    "La reunion con fecha \"" + commiteMeeting.getDate()
                    + "\" ha sido modificada exitosamente");

            FacesContext.getCurrentInstance().addMessage(null, msg);
        } 
        catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    ":\'(", "No se pudo eliminar el registro! " + e.getCause().getMessage());

            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onCancel(RowEditEvent event) {

        FacesMessage msg = new FacesMessage(":(", "Actualizacion cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
