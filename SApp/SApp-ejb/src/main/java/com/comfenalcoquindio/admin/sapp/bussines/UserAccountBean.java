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

    @Inject private UserAccountDAO userAccountDAO;
    
    @Override
    public int getSize(){
        return userAccountDAO.getSize();
    } 
    
    @Override
    public List<UserAccount> getAll(){
        return userAccountDAO.getAll();
    }

    @Override
    public void add(String username, String passwd, int profile, int idUser) {
        
        UserAccount userAccount = new UserAccount(); 
        
        userAccount.setUsername(username);
        userAccount.setPasswd(passwd);
        userAccount.setProfile(profile);
        userAccount.setIdUser(idUser);

        userAccountDAO.add(userAccount);
    }

    @Override
    public void update( UserAccount userAccount ) {
        
        userAccountDAO.update( userAccount );
    }

    @Override
    public void delete(UserAccount userAccount) {
        userAccountDAO.delete(userAccount);
    }

    @Override
    public UserAccount getByIdUser(int idUser) {
        return userAccountDAO.findByIdUser(idUser);
    }

    @Override
    public UserAccount getByLogin(String username, String passwd) {
        return userAccountDAO.getByLogin(username, passwd);
    }

    @Override
    public void save(UserAccount userAccount) {
        userAccountDAO.add(userAccount);
    }
}
