/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.bussines;

import com.comfenalcoquindio.admin.sapp.entity.CommitteMeeting;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rockerW7
 */
@Local
public interface ICommitteMeetingBean {
    
    public List<CommitteMeeting> getAll();
    
    public void add( Date date, String observations  );
    
    public void update( CommitteMeeting committeMeeting );
    
    public void delete( CommitteMeeting committeMeeting );
    
}
