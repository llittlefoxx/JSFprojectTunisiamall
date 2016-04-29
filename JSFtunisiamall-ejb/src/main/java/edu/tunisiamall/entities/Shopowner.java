package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("Shopowner")
@NamedQuery(name = "Shopowner.findAll", query = "SELECT s FROM User s")
public class Shopowner extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateActivation;

	public Shopowner() {
	}

	public Date getDateActivation() {
		return dateActivation;
	}

	public void setDateActivation(Date dateActivation) {
		this.dateActivation = dateActivation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}