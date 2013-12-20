/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalco.admin.sapp.controller;

import com.comfenalcoquindio.admin.sapp.eis.UserAccountDAO;
import com.comfenalcoquindio.admin.sapp.entity.UserAccount;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author rockerW7
 */
public class UserAccountControllerTest {
    
    private UserAccountController instance;
    @EJB private UserAccountDAO dao;
    
    public UserAccountControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAreaManagersList method, of class UserAccountController.
     */
    //@Test
    public void testGetAreaManagersList() {
        System.out.println("getAreaManagersList()");
        
        instance = new UserAccountController();       
    }

    /**
     * Test of getUserAccountsList method, of class UserAccountController.
     */
    //@Test
    public void testGetUserAccountsList() {
        System.out.println("getUserAccountsList()");
        
        instance = new UserAccountController();
        List<UserAccount> list = new ArrayList<>();
        list = instance.getUserAccountsList();
        
        for( UserAccount am : list ){
            System.out.println(am.toString());
        }
    }
}
