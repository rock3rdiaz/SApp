/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.dao;

import com.comfenalcoquindio.admin.sapp.entity.UserAccount;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rockerW7
 */

@Local
public interface IUserAccountsDAO {
    
    public List<UserAccount> getAll();
    
    public void create( UserAccount userAccount );
    
    public void update( UserAccount userAccount );
    
    public void delete( UserAccount userAccount );
}
