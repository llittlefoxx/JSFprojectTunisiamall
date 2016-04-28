package edu.tunisiamall.eventServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.tunisiamall.entities.Event;

/**
 * Session Bean implementation class GestionEvent
 */
@Stateless
public class GestionEvent implements GestionEventRemote, GestionEventLocal {
@PersistenceContext
EntityManager entityManager;
   
    public GestionEvent() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addEvent(Event event) {
		try {
			entityManager.persist(event);
			return true;
		} catch (Exception e) {
			return false;
			
		}
		
	}

	@Override
	public Boolean updateEvent(Event event) {
		try {
			entityManager.merge(event);
			return true;
		} catch (Exception e) {
			return false;
			
		}
	}



	@Override
	public Event findEventById(Integer idEvent) {
		Event event=null;
		try {
			event=entityManager.find(Event.class, idEvent);
			
			
			
		} catch (Exception e) {}
			return event;
			
		}	

	@Override
	public List<Event> findAllEvents() {
		Query query=entityManager.createQuery("select e from Event e");
		return query.getResultList();
	}
	
	@Override
	public List<Event> SearchEvent(String E) {

		Query query = entityManager.createQuery("select e from Event e where e.titleEvent like :Name").setParameter("Name","%" + E + "%");
		return query.getResultList();

	}

	@Override
	public Boolean deleteEvent(Event event) {
		try {
			entityManager.remove(entityManager.merge(event));
			return true;
		} catch (Exception e) {
			return false;
			
		}

}}
