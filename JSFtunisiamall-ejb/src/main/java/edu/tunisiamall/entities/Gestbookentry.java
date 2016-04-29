package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name = "Gestbookentry.findAll", query = "SELECT g FROM Gestbookentry g")
public class Gestbookentry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEntries;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEntrie;

	private int rating;

	private String text;

	@OneToOne
	private User user;

	public Gestbookentry() {
	}

	public int getIdEntries() {
		return this.idEntries;
	}

	public void setIdEntries(int idEntries) {
		this.idEntries = idEntries;
	}

	public Date getDateEntrie() {
		return this.dateEntrie;
	}

	public void setDateEntrie(Date dateEntrie) {
		this.dateEntrie = dateEntrie;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}