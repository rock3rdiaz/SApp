/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.eis;

import com.comfenalcoquindio.admin.sapp.entity.Order1;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rockerW7
 */
@Stateless
@LocalBean
public class OrderBeanDAO {
    
    @PersistenceContext( unitName = "com.comfenalcoquindio.admin_SApp-ejb_ejb_1.0PU" )
    private EntityManager em = null;
    
    public void save( Order1 order ){
        em.persist( order );
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
