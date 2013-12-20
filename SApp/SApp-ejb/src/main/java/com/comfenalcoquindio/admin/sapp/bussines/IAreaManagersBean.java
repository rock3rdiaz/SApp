/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.bussines;

import com.comfenalcoquindio.admin.sapp.entity.AreaManagers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rockerW7
 */
@Local
public interface IAreaManagersBean {
    
    public List<AreaManagers> getAll();
    
    public AreaManagers getByIdentification( int identification );
}
