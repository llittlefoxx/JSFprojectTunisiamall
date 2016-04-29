package edu.tunisiamall.shopOwnerServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.tunisiamall.entities.User;

import edu.tunisiamall.entities.Shopowner;


/**
 * Session Bean implementation class shopOwnerService
 */
@Stateless
public class shopOwnerService implements shopOwnerServiceRemote, shopOwnerServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public shopOwnerService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Shopowner> findAllSO() {
		return em.createQuery("select u from Shopowner u").getResultList();
	}

	@Override
	public void create(Shopowner shopowner) {
		em.persist(shopowner);		
	}

	@Override
	public void delete(Shopowner so) {
		em.remove(em.merge(so));
		
	}

	@Override
	public void updateShopeOwner(Shopowner sh) {
		em.merge(sh);
		
	}

	@Override
	public long count() {
		
		return (long) em.createQuery("select count(u) from Shopowner u").getSingleResult();
	}

	@Override
	public List<Shopowner> find(String chaine, String value) {
		if(value.equalsIgnoreCase("firstName")){
		return  em.createQuery("select u from Shopowner u where u.firstName like :chaine ")
				.setParameter("chaine", "%"+chaine+"%")
				.getResultList();
		}
		else if (value.equalsIgnoreCase("login")){
			return  em.createQuery("select u from Shopowner u where u.login like :chaine ")
					.setParameter("chaine", "%"+chaine+"%")
					.getResultList();
		}
		else if(value.equalsIgnoreCase("mail")){
			return  em.createQuery("select u from Shopowner u where u.mail like :chaine ")
					.setParameter("chaine", "%"+chaine+"%")
					.getResultList();
		}
		else if (value.equalsIgnoreCase("baned")){
			return  em.createQuery("select u from Shopowner u where u.baned=true ")
					.getResultList();
		}
		else return null;
	}

}
