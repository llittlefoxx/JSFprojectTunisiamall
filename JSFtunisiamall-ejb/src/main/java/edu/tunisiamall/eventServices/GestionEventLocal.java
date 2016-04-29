package edu.tunisiamall.eventServices;

import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.Event;

@Local
public interface GestionEventLocal {
	Boolean addEvent (Event event);
	Boolean updateEvent(Event event);
	Boolean deleteEvent(Event event);
	Event findEventById(Integer idEvent);
	List<Event> findAllEvents();

}
