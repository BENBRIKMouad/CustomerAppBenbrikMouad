/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.benbrik.customerappbenbrikmouad.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ma.benbrik.customerappbenbrikmouad.entities.DiscountCode;

/**
 *
 * @author benbrik_mouad
 */
@Stateless
public class DiscountCodeManager {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "customerPresistUnit")
    private EntityManager em;

    public List<DiscountCode> getAllDiscountCodes() {
        Query query = em.createNamedQuery("DiscountCode.findAll");
        return query.getResultList();
    }

    public DiscountCode findById(String discountCode) {
        return em.find(DiscountCode.class, discountCode);
    }
     public void persist(DiscountCode discountCode) {
        em.persist(discountCode);
    }

}
