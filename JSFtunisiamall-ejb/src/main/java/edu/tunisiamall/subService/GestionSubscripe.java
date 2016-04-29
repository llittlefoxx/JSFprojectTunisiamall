package edu.tunisiamall.subService;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.entities.Subscription;

/**
 * Session Bean implementation class GestionSubscripe
 */
@Stateless
public class GestionSubscripe implements GestionSubscripeRemote, GestionSubscripeLocal {

	@PersistenceContext
	EntityManager entityManager;
    public GestionSubscripe() {
    	
    }
    	public List<Subscription> findAllSub() {
    		Query query= entityManager.createNamedQuery("Subscription.findAll");
    		return query.getResultList();
    }

}
