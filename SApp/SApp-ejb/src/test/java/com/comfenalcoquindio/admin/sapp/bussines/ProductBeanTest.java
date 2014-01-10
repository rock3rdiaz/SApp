/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalcoquindio.admin.sapp.bussines;

import com.comfenalcoquindio.admin.sapp.entity.Product;
import java.util.ArrayList;
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
public class ProductBeanTest {

    private EJBContainer container = null;
    private Context ctx = null;

    public ProductBeanTest() {
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
     * Test of add method, of class ProductBean.
     */
    //@Test
    public void testAdd() throws Exception {
    }

    /**
     * Test of save method, of class ProductBean.
     */
    /*@Test
    public void testSave() throws Exception {
        System.out.println("save()");

        IProductBean instance = (IProductBean) ctx.
                lookup("java:global/classes/ProductBean");

        List<Product> list = new ArrayList<>();

        Product product1 = instance.add("Honda", "Negro mate", "Invicta suprema 150",
                "Version especial de los 50 años de Honda en Colombia", 100.0, 100.0);

        Product product2 = instance.add("AKT", "Negro", "AKT XM180",
                "Moto enduro insignia de la AKT", 200.0, 200.0);

        list.add(product1);
        list.add(product2);
        
        for( Product p : list ){
             System.out.println("Objecto sin grabar en BD: " + p);        
        }

        instance.save(product1);
        instance.save(product2);
        
        for( Product p : list ){
             System.out.println("Objecto ya grabado en BD: " + p);        
        }
    }*/

}
