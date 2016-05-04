package beans.events;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.google.gson.Gson;

import edu.tunisiamall.entities.Event;
import edu.tunisiamall.eventServices.GestionEventLocal;

@ManagedBean
public class EventsBeans {

	private List<Event> events;
	private Date dateNow;
	private String calender;
	private String DateEvent;
	private Event event = new Event();
	@EJB
	GestionEventLocal eventLocal;

	public String deleteEvent(int id) {
		
		Event e = new Event();
		e.setIdEvent(id);
		
		eventLocal.deleteEvent(e);
		return "eventList";
		
		
	}

	public String ajoutEvents() {
		try {

			DateFormat format = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
			Date date = format.parse(DateEvent);
			System.out.println(date);
			event.setDateEvent(date);
			eventLocal.addEvent(event);
			return "eventList";
		} catch (Exception e) {
			System.out.println(e.toString());
			return "";
		}
	}

	public Date getDateNow() {
		return new Date();
	}

	public void setDateNow(Date dateNow) {
		this.dateNow = dateNow;
	}

	public List<Event> getEvents() {
		return eventLocal.findAllEvents();
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public String getCalender() {

		try {
			List<Event> list = eventLocal.findAllEvents();
			List<eventCalender> eventCalenders = new ArrayList();
			for (Event event : list) {

				Calendar dateEnd = Calendar.getInstance();
				dateEnd.setTime(event.getDateEvent());
				dateEnd.add(Calendar.DATE, event.getPeriodEvent() - 1);

				Calendar dateStart = Calendar.getInstance();
				dateStart.setTime(event.getDateEvent());

				eventCalenders.add(new eventCalender(event.getTitleEvent(),
						dateStart.get(Calendar.YEAR) + "-" + (dateStart.get(Calendar.MONTH) + 1) + "-"
								+ dateStart.get(Calendar.DAY_OF_MONTH),
						dateEnd.get(Calendar.YEAR) + "-" + (dateEnd.get(Calendar.MONTH) + 1) + "-"
								+ dateEnd.get(Calendar.DAY_OF_MONTH)));
			}

			String json = new Gson().toJson(eventCalenders);
			System.out.println(json);
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
			return "";
		}

	}

	public void setCalender(String calender) {
		this.calender = calender;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getDateEvent() {
		return DateEvent;
	}

	public void setDateEvent(String dateEvent) {
		DateEvent = dateEvent;
	}
}

class eventCalender {

	private String title;
	private String start;
	private String end;

	public eventCalender(String title, String start, String end) {
		super();
		this.title = title;
		this.start = start;
		this.end = end;
	}

	public eventCalender() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
}
