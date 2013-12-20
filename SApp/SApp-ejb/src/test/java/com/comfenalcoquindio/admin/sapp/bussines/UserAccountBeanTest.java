/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalcoquindio.admin.sapp.bussines;

import com.comfenalcoquindio.admin.sapp.eis.UserAccountDAO;
import com.comfenalcoquindio.admin.sapp.entity.UserAccount;
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
public class UserAccountBeanTest {

    private EJBContainer container = null;
    private Context ctx = null;

    public UserAccountBeanTest() {
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
     * Test of getAll method, of class UserAccountBean.
     */
    //@Test
    public void testGetAll() throws Exception {

        System.out.println("getAll");

        IUserAccountBean instance = (IUserAccountBean) ctx.
                lookup("java:global/classes/UserAccountBean");

        List<UserAccount> result = instance.getAll();

        for (UserAccount userAccount : result) {
            System.out.println(" UserAccount Object: " + userAccount.toString());
        }
    }

    /**
     * Test of add method, of class UserAccountBean.
     */
    //@Test
    public void testAdd() throws Exception {

        System.out.println("add() Method");

        IUserAccountBean instance = (IUserAccountBean) ctx.
                lookup("java:global/classes/UserAccountBean");

        try {
            instance.add("batman", "rockys", 3, 1985);

            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println("ERROR! " + e.getCause());
        }
    }
    
    //@Test
    public void testGetByLogin() throws Exception {

        System.out.println("getByLogin() Method");

        IUserAccountBean instance = (IUserAccountBean) ctx.
                lookup("java:global/classes/UserAccountBean");

        try {
            UserAccount acount = instance.getByLogin("adminadmin", "reuaaaperto");            
            
            System.out.println("Object: " + acount.toString() );
            
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println("ERROR! " + e.getCause());
        }
    }

    //@Test
    public void testGetSize() throws Exception {

        System.out.println("getSize() Method");

        IUserAccountBean instance = (IUserAccountBean) ctx.
                lookup("java:global/classes/UserAccountBean");

        System.out.println("Size: " + instance.getSize());
    }

    //@Test
    public void testDelete() throws Exception {

        System.out.println("delete() Method");

        IUserAccountBean instance = (IUserAccountBean) ctx.
                lookup("java:global/classes/UserAccountBean");

        UserAccountDAO dao = new UserAccountDAO();

        try {
            UserAccount user = dao.findById(1);
            instance.delete(user);
            
            System.out.println("Delete: " + user.getIduserAccount());
            
            System.out.println("SUCCESS!");
            
        }
        catch( Exception e ){
            System.out.println("ERROR!: " + e.getCause());
        }

        
    }
}
