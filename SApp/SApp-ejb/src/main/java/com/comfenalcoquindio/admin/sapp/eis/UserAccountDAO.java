/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalcoquindio.admin.sapp.eis;

import com.comfenalcoquindio.admin.sapp.entity.UserAccount;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rockerW7
 */
@Stateless
public class UserAccountDAO {

    @PersistenceContext(unitName = "com.comfenalcoquindio.admin_SApp-ejb_ejb_1.0PU")
    private EntityManager em = null; 
    
    public List<UserAccount> getAll() {
        return em.createNamedQuery("UserAccount.findAll", UserAccount.class)
                .getResultList();
    }

    public int getSize() {
        return em.createNamedQuery("UserAccount.findAll", UserAccount.class)
                .getResultList()
                .size();
    }
    
    public void add( UserAccount userAccount ){
        em.persist( userAccount );        
    }
    
    public void update( UserAccount userAccount ){
        em.merge( userAccount );
    }
    
    public void delete( UserAccount userAccount ){
        em.merge( userAccount );
        em.remove( userAccount );
    }
    
    public UserAccount findById( Integer idUserAccount ){
        
        return em.createNamedQuery( "UserAccount.findByIduserAccount", UserAccount.class )
                .setParameter( "idUserAccount" , idUserAccount )
                .getSingleResult();
    }
}
