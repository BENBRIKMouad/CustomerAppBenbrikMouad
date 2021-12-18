/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import ma.benbrik.customerappbenbrikmouad.entities.Customer;
import ma.benbrik.customerappbenbrikmouad.entities.DiscountCode;
import ma.benbrik.customerappbenbrikmouad.session.CustomerManager;
import ma.benbrik.customerappbenbrikmouad.session.DiscountCodeManager;

/**
 *
 * @author benbrik_mouad
 */
@Named(value = "customerDetailsMBean")
@ViewScoped
public class CustomerDetailsMBean implements Serializable {

    private int idCustomer;
    private Customer customer;

    @EJB
    private CustomerManager customerManager;

    @EJB
    private DiscountCodeManager discountCodeManager;

    /**
     * Creates a new instance of CustomerDetailsMBean
     */
    public CustomerDetailsMBean() {
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Customer getDetails() {
        return customer;
    }

    public List<DiscountCode> getAllDiscountCodes() {
        return discountCodeManager.getAllDiscountCodes();
    }
    
    public Converter<DiscountCode> getDiscountCodeConverter() {
        return new Converter<DiscountCode>() { 
           
            @Override
            public DiscountCode getAsObject(FacesContext context, UIComponent component, String value) {
                return discountCodeManager.findById(value);
            }

           
            @Override
            public String getAsString(FacesContext context, UIComponent component, DiscountCode value) {
                return value.getDiscountCode();
            }
        };
    }

    public String update() {
        // Modifie la base de données.
        // Il faut affecter à customer.
        customer = customerManager.update(customer);
        return "CustomerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.getCustomer(idCustomer);
    }

}
