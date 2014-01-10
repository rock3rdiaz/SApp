/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.bussines;

import com.comfenalcoquindio.admin.sapp.dto.Order1DTO;
import com.comfenalcoquindio.admin.sapp.dto.ProductDTO;
import com.comfenalcoquindio.admin.sapp.dto.PurchaseRequestDTO;
import com.comfenalcoquindio.admin.sapp.entity.PurchaseRequest;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rockerW7
 */
@Local
public interface IPurchaseRequestBean {
    
    public void save( PurchaseRequest purchaseRequest );
    
    public void save( PurchaseRequestDTO purchaseRequestDTO, 
            List<ProductDTO> productDTOList,
            List<Order1DTO> order1DTOList);
}
