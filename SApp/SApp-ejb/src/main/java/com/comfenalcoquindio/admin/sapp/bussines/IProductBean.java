/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.bussines;

import com.comfenalcoquindio.admin.sapp.dto.ProductDTO;
import com.comfenalcoquindio.admin.sapp.entity.Product;
import javax.ejb.Local;

/**
 *
 * @author rockerW7
 */
@Local
public interface IProductBean {
    
    public void save( ProductDTO productDTO );
    
    public Product getLastSaved();
}
