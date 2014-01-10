/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalcoquindio.admin.sapp.bussines;

import com.comfenalcoquindio.admin.sapp.dto.Order1DTO;
import com.comfenalcoquindio.admin.sapp.dto.ProductDTO;
import com.comfenalcoquindio.admin.sapp.dto.PurchaseRequestDTO;
import com.comfenalcoquindio.admin.sapp.eis.PurchaseRequestDAO;
import com.comfenalcoquindio.admin.sapp.entity.Order1PK;
import com.comfenalcoquindio.admin.sapp.entity.PurchaseRequest;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PurchaseRequestBean implements IPurchaseRequestBean {

    @Inject private PurchaseRequestDAO purchaseRequestDAO;
    
    @Inject private IProductBean productBean;
    @Inject private IOrderBean orderBean;
    
    @Override
    public void save( PurchaseRequest purchaseRequest ){
        purchaseRequestDAO.save( purchaseRequest );
    }

    @Override
    public void save( PurchaseRequestDTO purchaseRequestDTO, 
            List<ProductDTO> productDTOList,
            List<Order1DTO> order1DTOList) {
        
        PurchaseRequest purchaseRequest = new PurchaseRequest();
                
        purchaseRequest.setIdarea( purchaseRequestDTO.getIdarea() );
        purchaseRequest.setObservations( purchaseRequestDTO.getObservations() );
        purchaseRequest.setSendDate( purchaseRequestDTO.getSendDate() );
        purchaseRequest.setState( purchaseRequestDTO.getState() );
        
        System.out.println("Before saved: " + purchaseRequest);        
        purchaseRequestDAO.save( purchaseRequest );        
        System.out.println("After saved: " + purchaseRequest);
        
        /*for( int i = 0; i < productDTOList.size(); i++ ){
            
            
            System.out.println("Index: " + i);
            
            productBean.save( productDTOList.get( i ) );   
            
            System.out.println("IdProduct: " + (i + 1) + productBean.getLastSaved().getIdproduct());
            System.out.println("IdPurchaseRequest: " + purchaseRequest.getIdpurchaseRequest());
            
            Order1PK order1PK = new Order1PK( purchaseRequest.getIdpurchaseRequest(), 
                    productBean.getLastSaved().getIdproduct() );
            
            orderBean.save( order1DTOList.get( i ) , productBean.getLastSaved(), purchaseRequest, order1PK);
        }*/
    }    
}
