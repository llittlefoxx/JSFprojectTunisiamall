package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "subscriptions")
@NamedQuery(name = "Subscription.findAll", query = "SELECT s FROM Subscription s")
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSubscription;

	@ManyToOne
	@JoinColumn(name = "idUser", insertable = false, updatable = false)
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "idEvent", insertable = false, updatable = false)
	private Event event;

	public Subscription() {
	}

	public int getIdSubscription() {
		return idSubscription;
	}

	public void setIdSubscription(int idSubscription) {
		this.idSubscription = idSubscription;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}