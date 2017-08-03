/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author admin
 */
@ManagedBean
@RequestScoped
public class TimerSessionBean implements Serializable {
    
    private Calendar calendar = Calendar.getInstance();
    
    @EJB
    private TestFacade testRows;
    
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
    
    public String getCalendar() {
        return calendar.getTime().toString();
    }
    
    public List < Test > selectAllTestRecords() {
        return testRows.findAll();
    }
    
}
