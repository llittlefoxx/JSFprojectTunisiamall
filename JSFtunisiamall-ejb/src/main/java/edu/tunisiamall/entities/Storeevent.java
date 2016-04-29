package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "Storeevent.findAll", query = "SELECT s FROM Storeevent s")
public class Storeevent implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StoreeventPK id;

	@ManyToOne
	@JoinColumn(name = "idStore", insertable = false, updatable = false)
	private Store store;

	@ManyToOne
	@JoinColumn(name = "idEvent", insertable = false, updatable = false)
	private Event event;

	public Storeevent() {
	}

	public StoreeventPK getId() {
		return this.id;
	}

	public void setId(StoreeventPK id) {
		this.id = id;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}