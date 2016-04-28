package edu.tunisiamall.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AnonimousRating
 *
 */
@Entity

public class AnonimousRating implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int rate;
	private Date date;
    private int idProd;
	private static final long serialVersionUID = 1L;

	public AnonimousRating() {
		super();
	}   
	public int getId() {
		return this.id;
	}
	
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public void setId(int id) {
		this.id = id;
	}   
	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
   
}
