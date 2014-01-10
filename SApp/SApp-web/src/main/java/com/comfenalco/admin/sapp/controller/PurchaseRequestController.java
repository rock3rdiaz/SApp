/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.sapp.controller;

import com.comfenalcoquindio.admin.sapp.bussines.IPurchaseRequestBean;
import com.comfenalcoquindio.admin.sapp.dto.PurchaseRequestDTO;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author rockerW7
 */
@Named(value = "purchaseRequestController")
@SessionScoped
public class PurchaseRequestController implements Serializable {

    private Integer idPurchaseRequest;
    private Date sendDate;
    private String observations;
    private int state;
    private int idArea;

    private PurchaseRequestDTO purchaseRequestDTO;

    @Inject
    private OrderController orderController;
    @Inject
    private ProductController productController;

    @EJB
    private IPurchaseRequestBean purchaseRequestBean;

    /**
     * @Summary: Instancia un solo objeto por sesion e inicializa sus
     * propiedades de manera interna, es decir, sin interaccion con el usuario.
     */
    public PurchaseRequestController() {

        HttpSession session = (HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false);

        sendDate = new Date();
        idArea = (int) session.getAttribute("idArea");
        state = 3; //3 = 'Por revisar' 

        purchaseRequestDTO = new PurchaseRequestDTO(sendDate, observations, state, idArea);
    }

    private void updateDTO() {
        purchaseRequestDTO.setObservations(observations);
    }

    /**
     * @Summary: Metodo que permite crear en memoria los objetos involucrados en
     * la solicitud de compra (formulario 'create.xhtml')
     */
    public void onAdd() {

        try {

            productController.add();
            orderController.add();

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    ":)", "Producto adicionado con exito!");

            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    ":\'(", "No se pudo adicionar el producto! " + e.getCause().getMessage());

            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onSave() {

        updateDTO();

        try {
            purchaseRequestBean.save(purchaseRequestDTO,
                    productController.getProductDTOList(), orderController.getOrderDTOList());
            
            productController.setProductDTOList();
            orderController.setOrderDTOList();
            
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    ":)", "Solicitud de compra registrada con exito!");

            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    ":\'(", "No se pudo registrar la solicitud de compra ! " + e.getCause());

            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onEdit(RowEditEvent event) {

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                ":)", "Registro actualizado con exito!");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                ":)", "Actualizacion cancelada!");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Integer getIdPurchaseRequest() {
        return idPurchaseRequest;
    }

    public void setIdPurchaseRequest(Integer idPurchaseRequest) {
        this.idPurchaseRequest = idPurchaseRequest;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(java.sql.Date sendDate) {
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
}
