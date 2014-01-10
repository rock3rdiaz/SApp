/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.dto;

/**
 *
 * @author rockerW7
 */
public class ProductDTO {
    
    private Integer idproduct;
    private String mark;
    private String color;
    private String model;
    private String description;
    private Double width;
    private Double high;

    public ProductDTO() {
    }

    public ProductDTO(String mark, String color, String model, String description, Double width, Double high) {
        this.mark = mark;
        this.color = color;
        this.model = model;
        this.description = description;
        this.width = width;
        this.high = high;
    }

    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }    
}
