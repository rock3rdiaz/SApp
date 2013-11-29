/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.sapp.examples;

import com.comfenalcoquindio.admin.sapp.bussines.UserAccountsImpl;
import com.comfenalcoquindio.admin.sapp.entity.UserAccount;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author rockerW7
 */
@Named(value = "exampleBean")
@RequestScoped
public class ExampleBean {
    
    private List<UserAccount> users;
    
    @Inject
    private UserAccountsImpl userAccount;

    public ExampleBean() {
    }
    
    public List<UserAccount> getUsers(){
        users = userAccount.getAll();
        return users;
    }
}
