/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalcoquindio.admin.sapp.bussines;

import com.comfenalcoquindio.admin.sapp.dto.ProductDTO;
import com.comfenalcoquindio.admin.sapp.eis.ProductDAO;
import com.comfenalcoquindio.admin.sapp.entity.Product;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProductBean implements IProductBean {

    private Product lastSaved;

    @Inject
    private ProductDAO productDAO;

    @Override
    public void save(ProductDTO productDTO) {

        Product p = new Product();

        p.setColor(productDTO.getColor());
        p.setDescription(productDTO.getDescription());
        p.setHigh(productDTO.getHigh());
        p.setWidth(productDTO.getWidth());
        p.setMark(productDTO.getMark());
        p.setModel(productDTO.getModel());

        productDAO.save(p);

        lastSaved = p;
    }

    @Override
    public Product getLastSaved() {
        return lastSaved;
    }
}
