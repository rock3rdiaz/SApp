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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author rockerW7
 */
public class PurchaseRequestBeanTest {

    private EJBContainer container = null;
    private Context ctx = null;

    public PurchaseRequestBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ctx = container.getContext();

        System.out.println("Container started");
    }

    @After
    public void tearDown() {

        container.close();

        System.out.println("Container stoped");
    }

    /**
     * Test of add method, of class PurchaseRequestBean.
     */
    @Test
    public void testSave() throws Exception {

        System.out.println("save() Method");

        IPurchaseRequestBean instance = (IPurchaseRequestBean) ctx.
                lookup("java:global/classes/PurchaseRequestBean");

        try {
            
            Date date = new Date();
            List<ProductDTO> productList = new ArrayList<>();
            List<Order1DTO> orderList = new ArrayList<>();
            
            PurchaseRequest purchaseRequest = new PurchaseRequest();
            purchaseRequest.setIdarea( 200 );
            purchaseRequest.setObservations( "blbalbablablabla" );
            purchaseRequest.setSendDate(date);
            purchaseRequest.setState(4);

           /* System.out.println("Before saved: " + purchaseRequest);            
            instance.save(purchaseRequest);            
            System.out.println("After saved: " + purchaseRequest);*/
            
            
            instance.save( new PurchaseRequestDTO( date , "No me diga que esta mierda esta funcionando asi ps", 152, 3 ),
                    productList, orderList );
            

            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println("ERROR! " + e.getCause().getMessage());
        }
    }

}
