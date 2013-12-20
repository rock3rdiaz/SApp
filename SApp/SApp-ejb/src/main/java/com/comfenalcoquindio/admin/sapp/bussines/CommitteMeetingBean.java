/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalcoquindio.admin.sapp.bussines;

import com.comfenalcoquindio.admin.sapp.eis.CommitteMeetingDAO;
import com.comfenalcoquindio.admin.sapp.entity.CommitteMeeting;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CommitteMeetingBean implements ICommitteMeetingBean {

    @Inject private CommitteMeetingDAO committeMettingDAO;   

    @Override
    public List<CommitteMeeting> getAll() {
        return committeMettingDAO.getAll();
    }

    @Override
    public void add(Date date, String observations) {
        
        CommitteMeeting committeMeeting = new CommitteMeeting();
        committeMeeting.setDate(date);
        committeMeeting.setObservations(observations);
        
        committeMettingDAO.add(committeMeeting);
    }

    @Override
    public void update(CommitteMeeting committeMeeting) {
        committeMettingDAO.update(committeMeeting);
    }

    @Override
    public void delete(CommitteMeeting committeMeeting) {
        committeMettingDAO.delete(committeMeeting);
    }
}
