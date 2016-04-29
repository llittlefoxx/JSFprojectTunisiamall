package edu.tunisiamall.customerServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.tunisiamall.entities.Customer;



/**
 * Session Bean implementation class customerServices
 */
@Stateless
public class customerServices implements customerServicesRemote, customerServicesLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public customerServices() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public List<Customer> findAllCos() {
		return em.createQuery("select u from Customer u ").getResultList();

	}
	@Override
	public void create(Customer cust) {
		em.persist(cust);		
	}

	@Override
	public void delete(Customer cust) {
		em.remove(em.merge(cust));
		
	}
	@Override
	public void updateCustomer(Customer cust) {
		em.merge(cust);
		
	}
	@Override
	public long count() {
		return (long) em.createQuery("select count(u) from Customer u").getSingleResult();

	}
	@Override
	public List<Customer> find(String chaine, String value) {
		if(value.equalsIgnoreCase("firstName")){
			return  em.createQuery("select u from Customer u where u.firstName like :chaine ")
					.setParameter("chaine", "%"+chaine+"%")
					.getResultList();
			}
			else if (value.equalsIgnoreCase("login")){
				return  em.createQuery("select u from Customer u where u.login like :chaine ")
						.setParameter("chaine", "%"+chaine+"%")
						.getResultList();
			}
			else if(value.equalsIgnoreCase("mail")){
				return  em.createQuery("select u from Customer u where u.mail like :chaine ")
						.setParameter("chaine", "%"+chaine+"%")
						.getResultList();
			}
			else if (value.equalsIgnoreCase("baned")){
				return  em.createQuery("select u from Customer u where u.baned=true ")
						.getResultList();
			}
			else return null;
	}
	

	
    


	

	

}
