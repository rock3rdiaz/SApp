/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalcoquindio.admin.sapp.eis;

import com.comfenalcoquindio.admin.sapp.entity.UserAccount;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.validation.ConstraintViolationException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author rockerW7
 */
public class UserAccountDAOTest {

    private EJBContainer container = null;
    private Context ctx = null;

    public UserAccountDAOTest() {
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
     * Test of getAll method, of class UserAccountDAO.
     */
    //@Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserAccountDAO instance = (UserAccountDAO) container.getContext().lookup("java:global/classes/UserAccountDAO");
        List<UserAccount> expResult = null;
        List<UserAccount> result = instance.getAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class UserAccountDAO.
     */
    //@Test
    public void testGetSize() throws Exception {
        System.out.println("getSize");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserAccountDAO instance = (UserAccountDAO) container.getContext().lookup("java:global/classes/UserAccountDAO");
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class UserAccountDAO.
     */
    //@Test
    public void testAdd() throws Exception {

        System.out.println("add() Method");

        UserAccountDAO instance = (UserAccountDAO) ctx.
                lookup("java:global/classes/UserAccountDAO");

        try {

            UserAccount user = new UserAccount();

            user.setUsername("sam_fisher");
            user.setPasswd("teroy");
            user.setProfile(2);
            user.setIdUser(654321);

            instance.add(user);

            System.out.println("SUCCESS!");

        } catch (ConstraintViolationException e) {
            System.out.println("ERROR! " + e.getCause());
        }
    }

    /**
     * Test of update method, of class UserAccountDAO.
     */
    //@Test
    public void testUpdate() throws Exception {

        System.out.println("update() Method");

        UserAccountDAO instance = (UserAccountDAO) ctx.
                lookup("java:global/classes/UserAccountDAO");

        try {

            UserAccount user = instance.findById(2);

            user.setUsername("rockerdiaz");

            instance.update(user);

            System.out.println("SUCCESS!");

        } catch (Exception e) {
            System.out.println("ERROR! " + e.getCause());
        }
    }

    /**
     * Test of delete method, of class UserAccountDAO.
     */
    //@Test
    public void testDelete() throws Exception {
        System.out.println("delete() Method");

        UserAccountDAO instance = (UserAccountDAO) ctx.
                lookup("java:global/classes/UserAccountDAO");

        try {

            UserAccount user = instance.findById(2);
            System.out.println("Object deleted: " + user);
            
            instance.delete(user);
            
            System.out.println("SUCCESS!");

        } catch (Exception e) {
            System.out.println("ERROR! " + e.getCause());
        }
    }

    /**
     * Test of findById method, of class UserAccountDAO.
     */
    //@Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Integer idUserAccount = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserAccountDAO instance = (UserAccountDAO) container.getContext().lookup("java:global/classes/UserAccountDAO");
        UserAccount expResult = null;
        UserAccount result = instance.findById(idUserAccount);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
