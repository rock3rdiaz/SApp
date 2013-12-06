/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.bussines;

import com.comfenalcoquindio.admin.sapp.entity.UserAccount;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rockerW7
 */
@Local
public interface IUserAccountBean {
    
    public List<UserAccount> getAll();
    
    public int getSize();
    
    public void add( String username, String passwd, String profile );
    
    public void update( Integer idUserAccount );
    
    public void remove( UserAccount userAccount );    
}
