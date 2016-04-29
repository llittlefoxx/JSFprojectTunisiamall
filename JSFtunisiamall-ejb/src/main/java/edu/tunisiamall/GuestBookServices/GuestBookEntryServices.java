package edu.tunisiamall.GuestBookServices;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.entities.Gestbookentry;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.userServices.userServicesLocal;

@Stateless
public class GuestBookEntryServices implements GuestBookEntryServicesRemote, GuestBookEntryServicesLocal {

	@PersistenceContext
	EntityManager em;
	@Inject
	userServicesLocal userEJB;

	public GuestBookEntryServices() {
	}

	@Override
	public void deleteEntries(int id) {
		em.remove(em.find(Gestbookentry.class, id));
	}

	@Override
	public List<Gestbookentry> findAll() {
		Query query = em.createNamedQuery("Gestbookentry.findAll");
		return query.getResultList();
	}

	@Override
	public Gestbookentry findEntryById(int idEtries) {
		return em.find(Gestbookentry.class, idEtries);
	}

	@Override
	public boolean addGuestbookEntry(int idUser, String text) {
		try {
			User u = userEJB.find(idUser);
			Query q = em.createQuery("select count(g.idEntries) from Gestbookentry g where g.user = :user")
					.setParameter("user",u);
			Long result = (Long) q.getSingleResult();
			if (result == 0) {
				Gestbookentry g = new Gestbookentry();
				g.setDateEntrie(new Date());
				g.setRating(-1);
				g.setText(text);
				g.setUser(u);
				em.persist(g);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
