/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.sapp.examples;

import com.comfenalcoquindio.admin.sapp.bussines.IUserAccountBean;
import com.comfenalcoquindio.admin.sapp.entity.UserAccount;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author rockerW7
 */
@Named(value = "exampleBean")
@RequestScoped
public class ExampleBean {

    @EJB
    private IUserAccountBean userAccountsBean;

    private List<UserAccount> userAccounts;
    private int size;

    /**
     * Creates a new instance of ExampleBean
     */
    public ExampleBean() {
    }

    public int getSize() {
        return userAccountsBean.getSize();
    }

    public List<UserAccount> getUserAccounts() {
        return userAccountsBean.getAll();
    }
}
