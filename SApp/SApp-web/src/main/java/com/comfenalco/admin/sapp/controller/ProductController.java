/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.sapp.controller;

import com.comfenalcoquindio.admin.sapp.dto.ProductDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author rockerW7
 */
@Named(value = "productController")
@SessionScoped
public class ProductController implements Serializable {

    private Integer idProduct;
    private String description;
    private String mark;
    private String color;
    private String model;
    private double width;
    private double high;

    private List<ProductDTO> productDTOList;
    
    /**
     * Creates a new instance of ProductController
     */
    public ProductController() {
        productDTOList = new ArrayList<>();        
    }

    public void add() {

        productDTOList.add( new ProductDTO(mark, color, model, description, width, high) );
        
        cleaningProperties();
    }
    
    private void cleaningProperties() {
        color = "";
        description = "";
        high = 0.0;
        mark = "";
        model = "";
        width = 0.0;
    }

    public List<ProductDTO> getProductDTOList() {
        return productDTOList;
    }
    
    public void setProductDTOList(){
        productDTOList.clear();
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }
}
