/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalcoquindio.admin.sapp.eis;

import com.comfenalcoquindio.admin.sapp.entity.CommitteMeeting;
import java.util.List;
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
public class CommitteMeetingDAO {

    @PersistenceContext(unitName = "com.comfenalcoquindio.admin_SApp-ejb_ejb_1.0PU")
    private EntityManager em = null;

    public List<CommitteMeeting> getAll() {
        return em.createNamedQuery("CommitteMeeting.findAll", CommitteMeeting.class)
                .getResultList();
    }

    public int getSize() {
        return em.createNamedQuery("CommitteMeeting.findAll", CommitteMeeting.class)
                .getResultList()
                .size();
    }

    public void add(CommitteMeeting committeMeeting) {
        em.persist(committeMeeting);
    }

    public void update(CommitteMeeting committeMeeting) {
        em.merge(committeMeeting);
    }

    public void delete(CommitteMeeting committeMeeting) {       
        em.remove( em.merge(committeMeeting) );
    }

    public CommitteMeeting findById(Integer idCommiteMeeting) {

        return em.createNamedQuery("CommitteMeeting.findByIdcommitteMeeting", CommitteMeeting.class)
                .setParameter("idCommitteMeeting", idCommiteMeeting)
                .getSingleResult();
    }
}
