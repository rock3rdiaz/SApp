/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.bussines;

import com.comfenalcoquindio.admin.sapp.eis.UserAccountDAO;
import com.comfenalcoquindio.admin.sapp.entity.UserAccount;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author rockerW7
 */
@Stateless
public class UserAccountBean implements IUserAccountBean{

    @Inject
    private UserAccountDAO userAccountDAO;
    
    @Override
    public int getSize(){
        return userAccountDAO.getSize();
    }   
    
    @Override
    public List<UserAccount> getAll(){
        return userAccountDAO.getAll();
    }

    @Override
    public void add(String username, String passwd, String profile) {
        
        UserAccount userAccount = new UserAccount();
        
        userAccount.setUsername(username);
        userAccount.setPasswd(passwd);
        userAccount.setProfile(profile);
        userAccount.setIdUser(10);

        userAccountDAO.add(userAccount);
    }

    @Override
    public void update( Integer idUserAccount ) {
        
        UserAccount userAccount = userAccountDAO.findById( idUserAccount );
        userAccountDAO.update( userAccount );
    }

    @Override
    public void remove(UserAccount userAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
