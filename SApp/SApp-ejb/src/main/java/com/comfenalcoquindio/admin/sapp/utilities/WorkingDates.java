/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalcoquindio.admin.sapp.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author rockerW7
 */
@Stateless
@LocalBean
public class WorkingDates {

    public Date StrToDate(String date) {

        java.sql.Date sqlDate = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
            java.util.Date dt = formatter.parse(date);
            sqlDate = new java.sql.Date(dt.getTime());
        } 
        catch (ParseException e) {
            e.printStackTrace();
        }

        return sqlDate;
    }
}
