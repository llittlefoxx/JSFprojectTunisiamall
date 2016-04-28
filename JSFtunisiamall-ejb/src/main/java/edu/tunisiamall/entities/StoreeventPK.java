package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class StoreeventPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "idEvent")
	private int idEvent;
	@Column(name = "idStore")
	private int idStore;

	public StoreeventPK() {
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public int getIdStore() {
		return idStore;
	}

	public void setIdStore(int idStore) {
		this.idStore = idStore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEvent;
		result = prime * result + idStore;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreeventPK other = (StoreeventPK) obj;
		if (idEvent != other.idEvent)
			return false;
		if (idStore != other.idStore)
			return false;
		return true;
	}

}