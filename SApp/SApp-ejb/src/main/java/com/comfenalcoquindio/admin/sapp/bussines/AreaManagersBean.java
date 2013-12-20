/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.bussines;

import com.comfenalcoquindio.admin.sapp.eis.AreaManagersDAO;
import com.comfenalcoquindio.admin.sapp.entity.AreaManagers;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Inject;

@Stateful
public class AreaManagersBean implements IAreaManagersBean {
    
    @Inject
    private AreaManagersDAO areaManagersDAO;

    @Override
    public List<AreaManagers> getAll() {
        return areaManagersDAO.getAll();
    }

    @Override
    public AreaManagers getByIdentification(int identification) {
        return areaManagersDAO.getByIdentification( identification );
    }    
}
