/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalcoquindio.admin.sapp.eis;

import com.comfenalcoquindio.admin.sapp.entity.UserAccount;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rockerW7
 */
@Stateless
@LocalBean
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
        em.remove(  em.merge( userAccount ) );
    }
    
    /**
     *@Summary: Retorna la cuenta de usuario que corresponde a la PK recibida
     * @param idUserAccount: PK de la cuenta de usuario
     * @return UserAccount: Cuenta de usuario
     */
    public UserAccount findById( Integer idUserAccount ){
        
        return em.createNamedQuery( "UserAccount.findByIduserAccount", UserAccount.class )
                .setParameter( "iduserAccount" , idUserAccount )
                .getSingleResult();
    }
    
    /**
     *@Summary: Retorna la cuenta de usuario que corresponde a la cedula del funcioario recibida
     * @param idUser: Numero de cedula del funcionario
     * @return UserAccount: Cuenta de usuario
     */
    public UserAccount findByIdUser( int idUser ){
        
        return em.createNamedQuery( "UserAccount.findByIdUser", UserAccount.class )
                .setParameter( "idUser" , idUser )
                .getSingleResult();
    }
    
    public UserAccount getByLogin( String username, String passwd ){
        return em.createNamedQuery( "UserAccount.findByUsernameAndPasswd", UserAccount.class )
                .setParameter( "username", username )
                .setParameter( "passwd", passwd )
                .getSingleResult();
    }
}
