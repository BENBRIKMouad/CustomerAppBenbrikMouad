/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.benbrik.customerappbenbrikmouad.session;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ma.benbrik.customerappbenbrikmouad.entities.Customer;

/**
 *
 * @author benbrik_mouad
 * <p>
 * For this specific implementation of the interface, you're better off
 * calling the more efficient {@link foo} method, provided you have the
 * additional arguments!
 * </p>
 */
@Stateless
public class CustomerManager {

    @PersistenceContext(unitName = "customerPresistUnit")
    private EntityManager em;

    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<Customer> getAllCustomers() { 
       Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList(); 
    }  
        
    public Customer update(Customer customer) {
      return em.merge(customer);
    }  

    public void persist(Object object) {
            em.persist(object);
    }
}
