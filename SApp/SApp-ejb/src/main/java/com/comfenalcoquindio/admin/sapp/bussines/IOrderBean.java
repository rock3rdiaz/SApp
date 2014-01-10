/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.bussines;

import com.comfenalcoquindio.admin.sapp.dto.Order1DTO;
import com.comfenalcoquindio.admin.sapp.entity.Order1PK;
import com.comfenalcoquindio.admin.sapp.entity.Product;
import com.comfenalcoquindio.admin.sapp.entity.PurchaseRequest;
import javax.ejb.Local;

/**
 *
 * @author rockerW7
 */
@Local
public interface IOrderBean {
    
    public void save( Order1DTO orderDTO, Product product, 
            PurchaseRequest purchaseRequest, Order1PK order1PK );
}
