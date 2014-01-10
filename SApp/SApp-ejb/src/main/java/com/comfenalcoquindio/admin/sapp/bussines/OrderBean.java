/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.bussines;

import com.comfenalcoquindio.admin.sapp.dto.Order1DTO;
import com.comfenalcoquindio.admin.sapp.eis.OrderBeanDAO;
import com.comfenalcoquindio.admin.sapp.entity.Order1;
import com.comfenalcoquindio.admin.sapp.entity.Order1PK;
import com.comfenalcoquindio.admin.sapp.entity.Product;
import com.comfenalcoquindio.admin.sapp.entity.PurchaseRequest;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class OrderBean implements IOrderBean {
    
    @Inject private OrderBeanDAO orderBeanDAO;

    @Override
    public void save( Order1DTO orderDTO, 
            Product product, PurchaseRequest purchaseRequest, Order1PK order1PK ) {
        
        Order1 order = new Order1();
        
        order.setAmount(orderDTO.getAmount());
        order.setJustification( orderDTO.getJustification() );
        order.setNeedDate( orderDTO.getNeedDate() );
        order.setType( orderDTO.getType() );
        order.setOrder1PK(order1PK);
        order.setProduct(product);
        order.setPurchaseRequest(purchaseRequest);
        
        orderBeanDAO.save( order );
    }
}
