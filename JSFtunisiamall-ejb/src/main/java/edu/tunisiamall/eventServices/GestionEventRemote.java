package edu.tunisiamall.eventServices;

import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Event;

@Remote
public interface GestionEventRemote {
	public Boolean addEvent (Event event);
	public Boolean updateEvent(Event event);
	public Boolean deleteEvent(Event event);
	public Event findEventById(Integer idEvent);
	public List<Event> findAllEvents();
	public List<Event> SearchEvent(String E);
}
