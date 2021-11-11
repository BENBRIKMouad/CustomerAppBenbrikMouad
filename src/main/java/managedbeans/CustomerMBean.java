/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import ma.benbrik.customerappbenbrikmouad.entities.Customer;
import ma.benbrik.customerappbenbrikmouad.session.CustomerManager;

/**
 *
 * @author benbrik_mouad
 */
@Named(value = "customerMBean")
@ViewScoped
public class CustomerMBean implements Serializable {
    private List<Customer> customerList; 
    
    @EJB
    private CustomerManager customerManager;

    /**
     * Creates a new instance of CustomerMBean
     */
    public CustomerMBean() { }
    
    public List<Customer> getAllCustomers(){
        if (customerList == null)
            customerList = customerManager.getAllCustomers();
        return customerList;
    }
    
    
}
